package comapps.com.lakewoodsmokehousend.menu;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;

import java.util.ArrayList;
import java.util.List;

import comapps.com.lakewoodsmokehousend.LoadingCallback;
import comapps.com.lakewoodsmokehousend.R;

/**
 * Created by me on 9/29/2015.
 */
public class MenuListViewFragment extends ListFragment {
    private static final String TAG = "MENULISTVIEWFRAGMENT ";
    private static final String ARG_PAGE_NUMBER = "page_number";

    private BackendlessCollection<Menu> menu;
    private List<Menu> menuComplete = new ArrayList<>();
    private MenuListViewAdapter adapter;


    public MenuListViewFragment() {

    }

    public static MenuListViewFragment newInstance(int page) {
        MenuListViewFragment fragment = new MenuListViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, page);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.menulistfragment, container, false);


    }


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int groupId = getArguments().getInt(ARG_PAGE_NUMBER, 1);


        QueryOptions queryOptions = new QueryOptions();
        queryOptions.addSortByOption("sort ASC");
        queryOptions.setPageSize(100);
        BackendlessDataQuery query = new BackendlessDataQuery();
        query.setQueryOptions(queryOptions);

        String whereClause = "groupsort = " + String.valueOf(groupId);
        Log.i(TAG, whereClause);
        query.setWhereClause(whereClause);

        Backendless.Data.of( Menu.class ).find(query, new LoadingCallback<BackendlessCollection<Menu>>
                (getActivity(), "loading menu items...", true) {

            @Override
            public void handleResponse(BackendlessCollection<Menu> menuBackendlessCollection) {
                menu = menuBackendlessCollection;
                addMoreItems( menuBackendlessCollection );
                super.handleResponse(menuBackendlessCollection);
            }

        });



        adapter = new MenuListViewAdapter(getActivity(), menuComplete);



        setListAdapter(adapter);

        adapter.notifyDataSetChanged();

    }

    private void addMoreItems( BackendlessCollection<Menu> nextPage) {
        menuComplete.addAll(nextPage.getCurrentPage());
        Log.i(TAG, "*** menuComplete List " + menuComplete.toString());
        adapter.notifyDataSetChanged();

    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDivider(new ColorDrawable(Color.BLACK));
        getListView().setDividerHeight(0);
    }


}



