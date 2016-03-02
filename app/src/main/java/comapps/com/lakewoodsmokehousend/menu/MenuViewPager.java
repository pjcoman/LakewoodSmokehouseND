package comapps.com.lakewoodsmokehousend.menu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
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
public class MenuViewPager extends Fragment {

    private static final String TAG = "MENUVIEWPAGER ";

    public static TabLayout tabLayout;
    private static ArrayList<String> menuGroups = new ArrayList<>();



    MyAdapter adapter = null;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_viewpager_menu, container, false);
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

            menuGroups = getMenuGroups();

        }


        @Override
        public Fragment getItem(int position) {
            System.out.println(String.valueOf(getContext().getClass()) + "Size of menuGroups is " + menuGroups.size());
            String idOfSendingActivity = "";
            Log.d(TAG, "Sending activity is " + idOfSendingActivity);


            return MenuListViewFragment.newInstance(position + 1);


        }


        @Override
        public int getCount() {


            return menuGroups.size();


        }

        @Override
        public CharSequence getPageTitle(int position) {


            for (int i = 0; i < menuGroups.size(); i++) {
                Log.v(TAG, "Array Value " + menuGroups.get(i));

                if (position == i) {

                    return new SpannableStringBuilder(" " + menuGroups.get(i));
                }
            }

            return null;
        }
    }

    private static ArrayList<String> getMenuGroups() {

        menuGroups.clear();



        List<ParseObject> ob;


        try {

            ParseQuery<ParseObject> query = new ParseQuery<>(
                    "ls_groups").fromLocalDatastore();
            query.orderByAscending("sort").whereEqualTo("type", "EATS");
            ob = query.find();


            for (ParseObject menu : ob) {
                // Locate images in flag column

                menuGroups.add((String) menu.get("group"));

            }

        } catch (ParseException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return (menuGroups);
    }




}

