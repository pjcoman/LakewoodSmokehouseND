package comapps.com.lakewoodsmokehousend.togo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.melnykov.fab.FloatingActionButton;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import comapps.com.lakewoodsmokehousend.MySharedPreferences;
import comapps.com.lakewoodsmokehousend.R;
import comapps.com.lakewoodsmokehousend.menu.MenuObject;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;


public class ToGoRecyclerFragment extends Fragment {
    private static final String TAG = "LAKEWOOD SMOKEHOUSE";
    //  ArrayList<MenuObject> menu = new ArrayList<>();
    private ArrayList<MenuObject> order;


    private ToGoRecyclerAdapter adapter;

    private MySharedPreferences sharedPreferences;
    private Gson gson;

    Intent intent = null, chooser = null;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.togolist_recyclerview, container, false);




        gson = new Gson();
        sharedPreferences = new MySharedPreferences(getActivity().getApplicationContext());


        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        //    recyclerView.setItemAnimator(new SlideInUpAnimator());


        final StaggeredGridLayoutManager manager;


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
            manager.setGapStrategy((StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS));
            recyclerView.setLayoutManager(manager);
        } else {
            manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
            manager.setGapStrategy((StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS));
            recyclerView.setLayoutManager(manager);
        }

        if (savedInstanceState != null) {

            getOrderItemListFromSharedpreferences();
            adapter = new ToGoRecyclerAdapter(order, getActivity().getApplicationContext());

        } else {

            ArrayList<MenuObject> menu = getData();
            adapter = new ToGoRecyclerAdapter(menu, getActivity().getApplicationContext());

        }

        recyclerView.setAdapter(adapter);
        SlideInRightAnimationAdapter adapterRight = new SlideInRightAnimationAdapter(adapter);
        adapterRight.setDuration(500);
        recyclerView.setAdapter(adapterRight);


        final FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
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
                    Toast toast = Toast.makeText(v.getContext(), order, Toast.LENGTH_LONG);
                    LinearLayout toastLayout = (LinearLayout) toast.getView();
                    TextView toastTV = (TextView) toastLayout.getChildAt(0);
                    toastTV.setTextSize(12);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                    intent = new Intent(Intent.ACTION_SEND);
                    intent.setData(Uri.parse("mailto:"));
                    intent.setType("message/rfc822");
                    String[] send_to = {"email.pete@yahoo.com", "evil_chopsticks@yahoo.com"};
                    intent.putExtra(Intent.EXTRA_EMAIL, send_to);
                  //  blind carbon copy
                  //  intent.putExtra(Intent.EXTRA_BCC, address);
                  //  carbon copy
                  //  intent.putExtra(Intent.EXTRA_CC, address);

                    TelephonyManager tMgr = (TelephonyManager)getContext().getSystemService(Context.TELEPHONY_SERVICE);
                    String mPhoneNumber = tMgr.getLine1Number();

                    StringBuilder splitPhoneNum = new StringBuilder(mPhoneNumber);
                    String ac = splitPhoneNum.substring(0,3);
                    String nxx = splitPhoneNum.substring(3,6);
                    String xxxx = splitPhoneNum.substring(6);

                    intent.putExtra(Intent.EXTRA_SUBJECT, "ORDER FOR PICKUP from " + "(" + ac + ")" + nxx + "-" + xxxx);
                    intent.putExtra(Intent.EXTRA_TEXT, adapter.getOrder());
                 //   intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://comapps.com.lakewoodsmokehousend/drawable/" + R.drawable.ls_icon));

                    chooser = Intent.createChooser(intent, "Select Email app...");

                    if ( intent.resolveActivity(getContext().getPackageManager()) != null) {
                        startActivity(chooser);

                    }




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


    private static ArrayList<MenuObject> getData() {

        ArrayList<MenuObject> data = new ArrayList<>();

        try {

            ParseQuery<ParseObject> query = new ParseQuery<>(
                    "ls_menu").fromLocalDatastore();

            query.orderByAscending("groupsort").addAscendingOrder("sort");

            List<ParseObject> ob;

            ob = query.find();


            for (ParseObject parseObject : ob) {

                String tempItem = (String) parseObject.get("item");
                String tempGroup = (String) parseObject.get("group");
                String tempPrice = (String) parseObject.get("price");


                MenuObject menuItem = new MenuObject();

                if (parseObject.get("item") != null && !parseObject.get("item").equals("") && !parseObject.get("item").equals("null")) {
                    //    Log.i("tempItem is ", tempItem);
                    menuItem.setItem(tempItem);
                }

                if (parseObject.get("group") != null && !parseObject.get("group").equals("") && !parseObject.get("group").equals("null")) {
                    //    Log.i("tempGroup is ", tempGroup);
                    menuItem.setGroup(tempGroup);
                }

                if (parseObject.get("price") != null && !parseObject.get("price").equals("") && !parseObject.get("price").equals("null")) {
                    //    Log.i("tempPrice is ", tempPrice);
                    menuItem.setPrice(tempPrice);
                }

                menuItem.setQuantityLabel("");
                menuItem.setQuantity(0);
                menuItem.setSelection(0);
                menuItem.setSelection2(0);
                menuItem.setSelection3(0);
                menuItem.setSelection4(0);
                menuItem.setSelection5(0);
                menuItem.setSelection6(0);


                if (tempItem != null) {
                    data.add(menuItem);
                }

            }


        } catch (ParseException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        return data;

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);


        ArrayList<MenuObject> order;

        // pulls menu ArrayList<MenuObject> from adapter

        order = adapter.getOrderList();

        saveOrderItemListToSharedpreferences(order);


    }

    private void saveOrderItemListToSharedpreferences(ArrayList<MenuObject> order) {

        //  Log.i(TAG, "order ArrayList " + order.toString());

        String jsonOrderItem = gson.toJson(order);
        sharedPreferences.saveOrderItemsList(jsonOrderItem);


    }

    private void getOrderItemListFromSharedpreferences() {
        order = new ArrayList<>();

        String jsonOrderItem = sharedPreferences.getOrderItemsList();
        Type type = new TypeToken<List<MenuObject>>() {
        }.getType();
        order = gson.fromJson(jsonOrderItem, type);
    }



}

