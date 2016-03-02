package comapps.com.lakewoodsmokehousend.drinks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import comapps.com.lakewoodsmokehousend.R;


/**
 * Created by me on 10/6/2015.
 */
public class DrinksViewPager extends Fragment {

    private static final String TAG = "DRINKSVIEWPAGER";
    private static ArrayList<String> drinkGroups = new ArrayList<>();





    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_viewpager_drinks, container, false);
        //  tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));


    /*    tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
*/
        return v;



    }


    public class MyAdapter extends FragmentStatePagerAdapter {


        public MyAdapter(FragmentManager fm) {
            super(fm);

            drinkGroups = getDrinkGroups();

        }


        @Override
        public Fragment getItem(int position) {
            System.out.println(String.valueOf(getContext().getClass()) + drinkGroups.size());
            String idOfSendingActivity = "";
            Log.i(TAG, "Sending activity is " + idOfSendingActivity);



            return DrinksListViewFragment.newInstance(position + 1, idOfSendingActivity);

        }



        @Override
        public int getCount() {


            return drinkGroups.size();


        }



        @Override
        public CharSequence getPageTitle(int position) {



            for (int i = 0; i < drinkGroups.size(); i++) {
            //    Log.i(TAG, "Array Value " + drinkGroups.get(i));

                if (position == i) {

                    return new SpannableStringBuilder(" " + drinkGroups.get(i));
                }
            }

            return null;
        }
    }

    private static ArrayList<String> getDrinkGroups()    {

        drinkGroups.clear();


        List<ParseObject> ob;



        try {

            ParseQuery<ParseObject> query = new ParseQuery<>(
                    "ls_groups").fromLocalDatastore();
            query.orderByAscending("sort").whereEqualTo("type", "DRINKS");
            ob = query.find();


            for (ParseObject menu : ob) {
                // Locate images in flag column

                drinkGroups.add((String) menu.get("group"));

            }

        } catch (ParseException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return(drinkGroups);
    }





}

