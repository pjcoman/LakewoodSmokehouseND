package comapps.com.lakewoodsmokehousend.drinks;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

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
public class DrinksListViewFragment extends ListFragment {

    private static final String TAG = "DRINKSLISTVIEWFRAGMENT";

    private static final String ARG_PAGE_NUMBER = "page_number";
    private static final String ARG_SENDING_ACTIVITY = "number_of_pages";
    private int x = 0;
    private int y = 0;


    private BackendlessCollection<Drinks> drinks;
    private List<Drinks> drinkList = new ArrayList<>();
    private DrinksListViewAdapter adapter;




    public DrinksListViewFragment() {

    }

    public static DrinksListViewFragment newInstance(int page) {
        DrinksListViewFragment fragment = new DrinksListViewFragment();


        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, page);

        fragment.setArguments(args);
        


        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.drinkslistfragment, container, false);

    }


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int groupId = getArguments().getInt(ARG_PAGE_NUMBER, 1);




        adapter = new DrinksListViewAdapter(getActivity(), drinkList);

        setListAdapter(adapter);

        QueryOptions queryOptions = new QueryOptions();
        queryOptions.addSortByOption("item ASC");
        queryOptions.setPageSize(100);
        BackendlessDataQuery query = new BackendlessDataQuery();
        query.setQueryOptions(queryOptions);

        String whereClause = "groupsort = " + String.valueOf(groupId);
        Log.i(TAG, whereClause);
        query.setWhereClause(whereClause);

        Backendless.Data.of( Drinks.class ).find(query, new LoadingCallback<BackendlessCollection<Drinks>>
                (getActivity(), "loading drink items...", true) {

            @Override
            public void handleResponse(BackendlessCollection<Drinks> drinksBackendlessCollection) {
                drinks = drinksBackendlessCollection;
                addMoreItems( drinksBackendlessCollection );
                super.handleResponse(drinksBackendlessCollection);
            }

        });

        adapter.notifyDataSetChanged();

    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        x = x + 1;
        y = y + 1;

        int groupId = getArguments().getInt(ARG_PAGE_NUMBER, 1);
        String groupIdString = Integer.toString(groupId);
        System.out.println(TAG + "Group ID ARG_PAGE_NUMBER is " + groupIdString);

        if ( groupId == 1) {

            y = 6;

        } else {

            y = 2;

        }

        if (x == y) {

            x = 0;

        }

        String[] toastSort = new String[8];
        toastSort[0] = "Sorted by name Ascending";
        toastSort[1] = "by name descending";
        toastSort[2] = "by abv (alcohol by volume) ascending";
        toastSort[3] = "by abv descending";
        toastSort[4] = "by IBU (bitterness) ascending";
        toastSort[5] = "by IBU descending";

        String tm = toastSort[x];

        Toast sort = Toast.makeText(getActivity(), tm, Toast.LENGTH_SHORT);
        sort.setGravity(Gravity.CENTER, 0, 0);
        sort.show();

        QueryOptions queryOptions = new QueryOptions();



        switch (x) {
            case 0:
                queryOptions.addSortByOption("item ASC");
                break;
            case 1:
                queryOptions.addSortByOption("item DESC");
                break;
            case 2:
                queryOptions.addSortByOption("abv ASC");
                break;
            case 3:
                queryOptions.addSortByOption("abv DESC");
                break;
            case 4:
                queryOptions.addSortByOption("IBU ASC");
                break;
            case 5:
                queryOptions.addSortByOption("IBU DESC");
                break;
        }


        queryOptions.setPageSize(100);
        BackendlessDataQuery query = new BackendlessDataQuery();
        query.setQueryOptions(queryOptions);

        String whereClause = "groupsort = " + String.valueOf(groupId);
        Log.i(TAG, whereClause);
        query.setWhereClause(whereClause);

        Backendless.Data.of( Drinks.class ).find(query, new LoadingCallback<BackendlessCollection<Drinks>>
                (getActivity(), "loading drink items...", true) {

            @Override
            public void handleResponse(BackendlessCollection<Drinks> drinksBackendlessCollection) {
                drinks = drinksBackendlessCollection;
                addMoreItems( drinksBackendlessCollection );
                super.handleResponse(drinksBackendlessCollection);
            }

        });



    }

    private void addMoreItems( BackendlessCollection<Drinks> nextPage) {
        drinkList.clear();
        drinkList.addAll(nextPage.getCurrentPage());
        adapter.notifyDataSetChanged();

    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDivider(new ColorDrawable(Color.BLACK));
        getListView().setDividerHeight(0);
    }



}






















