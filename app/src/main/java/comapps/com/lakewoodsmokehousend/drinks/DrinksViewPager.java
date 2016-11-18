package comapps.com.lakewoodsmokehousend.drinks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;

import java.util.ArrayList;

import comapps.com.lakewoodsmokehousend.R;
import comapps.com.lakewoodsmokehousend.menu.MenuGroups;


/**
 * Created by me on 10/6/2015.
 */
public class DrinksViewPager extends Fragment {

    private static final String TAG = "DRINKSVIEWPAGER ";
    private static ArrayList<String> menuGroups = new ArrayList<>();

    ViewPager viewPager;


    int numberOfFragments = 4;





    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_viewpager_drinks, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        PagerTabStrip pagerTabStrip = (PagerTabStrip) v.findViewById(R.id.pagerTabStrip);




        return v;




    }


    public class MyAdapter extends FragmentStatePagerAdapter {


        public MyAdapter(FragmentManager fm) {
            super(fm);


            menuGroups = getMenuGroups();




        }


        @Override
        public Fragment getItem(int position) {
            System.out.println(String.valueOf(getContext().getClass()) + "Size of menuGroups is " + menuGroups.size());
            String idOfSendingActivity = "";
            Log.d(TAG, "Sending activity is " + idOfSendingActivity);



            return DrinksListViewFragment.newInstance(position + 1);


        }


        @Override
        public int getCount() {

            return numberOfFragments;
        }

        @Override
        public CharSequence getPageTitle(int position) {


            for (int i = 0; i < menuGroups.size(); i++) {
                Log.v(TAG, "Array Value " + menuGroups.get(i));

                if (position == i) {

                    return new SpannableStringBuilder(" " + menuGroups.get(i));
                }
            }

            if ( position == 0 ) {
                return "BEERS";
            }

            return null;

        }


    }



    private static ArrayList<String> getMenuGroups() {



        menuGroups.clear();

        BackendlessDataQuery query = new BackendlessDataQuery();

        QueryOptions queryOptions = new QueryOptions();
        queryOptions.addSortByOption("sort ASC");
        queryOptions.setPageSize(20);
        query.setQueryOptions(queryOptions);

        Backendless.Persistence.of( MenuGroups.class).find(query, new AsyncCallback<BackendlessCollection<MenuGroups>>() {
            @Override
            public void handleResponse(BackendlessCollection<MenuGroups> foundGroups) {
                // all Contact instances have been found

                for (MenuGroups groups : foundGroups.getData()) {

                    if (groups.getType().contains("DRINKS")) {

                        menuGroups.add(groups.getGroup());

                        Log.i(TAG, groups.getGroup());

                    }
                }


            }

            @Override
            public void handleFault(BackendlessFault fault) {
                // an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });





        return(menuGroups);





    }




}
