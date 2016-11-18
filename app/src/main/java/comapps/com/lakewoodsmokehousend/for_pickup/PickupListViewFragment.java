package comapps.com.lakewoodsmokehousend.for_pickup;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.melnykov.fab.FloatingActionButton;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import comapps.com.lakewoodsmokehousend.LoadingCallback;
import comapps.com.lakewoodsmokehousend.MySharedPreferences;
import comapps.com.lakewoodsmokehousend.PopUpOrder;
import comapps.com.lakewoodsmokehousend.R;
import comapps.com.lakewoodsmokehousend.menu.Menu;


/**
 * Created by me on 9/29/2015.
 */
public class PickupListViewFragment extends Fragment {
    private static final String TAG = "PICKUPLISTVIEWFRAGMENT ";


    private BackendlessCollection<Menu> menu;
    private List<Menu> order = new ArrayList<>();
    private PickupListViewAdapter adapter;
    private MySharedPreferences sharedPreferences;
    private Gson gson;


    RecyclerView recyclerView;
    FloatingActionButton fab;


    public PickupListViewFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        View rootView = inflater.inflate(R.layout.pickup_recyclerview, container, false);


        gson = new Gson();
        sharedPreferences = new MySharedPreferences(getActivity().getApplicationContext());

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        //    recyclerView.setItemAnimator(new SlideInUpAnimator());


        final StaggeredGridLayoutManager manager;


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            manager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL);
            manager.setGapStrategy((StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS));
            recyclerView.setLayoutManager(manager);
        } else {
            manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
            manager.setGapStrategy((StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS));
            recyclerView.setLayoutManager(manager);
        }

        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.attachToRecyclerView(recyclerView);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String order = adapter.getOrder();
                if (order.isEmpty()) {
                    Toast toast = Toast.makeText(v.getContext(), "order is empty", Toast.LENGTH_LONG);
                    LinearLayout toastLayout = (LinearLayout) toast.getView();
                    TextView toastTV = (TextView) toastLayout.getChildAt(0);
                    toastTV.setTextSize(12);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                } else {


                    Intent i = new Intent(v.getContext(), PopUpOrder.class);
                    i.putExtra("order", adapter.getOrder());
                    startActivity(i);




                }

            }
        });


        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(500);
        itemAnimator.setRemoveDuration(500);
        recyclerView.setItemAnimator(itemAnimator);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //    Log.i(TAG, "ScrollListener dx " + String.valueOf(dx));

                if (dx == 0) {

                    fab.setVisibility(View.INVISIBLE);

                } else {

                    fab.setVisibility(View.VISIBLE);

                }
            }
        });
        return rootView;
    }



    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        QueryOptions queryOptions = new QueryOptions();
        queryOptions.addSortByOption("groupsort ASC");
        queryOptions.setPageSize(100);
        BackendlessDataQuery query = new BackendlessDataQuery();
        query.setQueryOptions(queryOptions);

        String whereClause = "price != ''";
       // Log.i(TAG, whereClause);
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

        if (savedInstanceState != null) {

            Log.i(TAG, "savedInstanceState not equal to null");

            getOrderItemListFromSharedpreferences();
            adapter = new PickupListViewAdapter(order, getActivity().getApplicationContext());

        } else {

            Log.i(TAG, "savedInstanceState equal to null");

            adapter = new PickupListViewAdapter(order, getActivity().getApplicationContext());

        }







        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

    }

    private void addMoreItems( BackendlessCollection<Menu> nextPage) {
        order.addAll(nextPage.getCurrentPage());

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);


        List<Menu> order;



        order = adapter.getOrderList();

        saveOrderItemListToSharedpreferences(order);


    }

    private void saveOrderItemListToSharedpreferences(List<Menu> order) {

        //  Log.i(TAG, "order ArrayList " + order.toString());

        String jsonOrderItem = gson.toJson(order);
        sharedPreferences.saveOrderItemsList(jsonOrderItem);


    }

    private void getOrderItemListFromSharedpreferences() {

        String jsonOrderItem = sharedPreferences.getOrderItemsList();
        Type type = new TypeToken<List<Menu>>() {
        }.getType();
        order = gson.fromJson(jsonOrderItem, type);
    }





}



