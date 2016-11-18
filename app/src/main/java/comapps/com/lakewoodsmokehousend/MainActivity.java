package comapps.com.lakewoodsmokehousend;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.backendless.Backendless;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import comapps.com.lakewoodsmokehousend.drinks.DrinksViewPager;
import comapps.com.lakewoodsmokehousend.for_pickup.PickupListViewFragment;
import comapps.com.lakewoodsmokehousend.menu.MenuViewPager;
import comapps.com.lakewoodsmokehousend.reviews.AddReview;
import comapps.com.lakewoodsmokehousend.reviews.ReviewListViewFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAINACTIVITY";

    private static final String STATE_SELECTED_POSITION = "state_selected_position";
    private static final String COUNTER = "counter";

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private FragmentManager mFragmentManager;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mCurrentSelectedPosition;

    PickupListViewFragment pickupListViewFragment;





    private int counter = 0;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String appVersion = "v1";
        Backendless.initApp(this, "D78A1585-9378-C5D7-FF12-BA4946E54E00", "2A1D54E4-A6D4-04AB-FF7B-113721FD2F00", appVersion);

        if (savedInstanceState != null){
            counter = savedInstanceState.getInt(COUNTER);
        }




     /*   BackendlessUser user = new BackendlessUser();
        user.setEmail( "pjcoman@gmail.com" );
        user.setPassword( "Ma060789" );

        Backendless.UserService.register( user, new BackendlessCallback<BackendlessUser>()
        {
            @Override
            public void handleResponse( BackendlessUser backendlessUser )
            {
                Log.i( "Registration", backendlessUser.getEmail() + " successfully registered" );
            }
        } );
*/


        Log.i(TAG, "counter from sis (top) " + String.valueOf(counter));

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MerriweatherSans-Italic.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        setContentView(R.layout.activity_main);

        final Button eat = (Button) findViewById(R.id.eatbutton);
        final Button drink = (Button) findViewById(R.id.drinkbutton);
        final Button pickup = (Button) findViewById(R.id.togobutton);


        if ( counter == 0 ) {



            Log.i(TAG, " counter == 0 " + String.valueOf(counter));

            eat.setVisibility(View.VISIBLE);
            drink.setVisibility(View.VISIBLE);
            pickup.setVisibility(View.VISIBLE);
           /* addReview.setVisibility(View.INVISIBLE);
            readReview.setVisibility(View.INVISIBLE);*/

        } else {

            counter = savedInstanceState.getInt(COUNTER);

            Log.i(TAG, "counter else " + String.valueOf(counter));

            eat.setVisibility(View.INVISIBLE);
            drink.setVisibility(View.INVISIBLE);
            pickup.setVisibility(View.INVISIBLE);
           /* addReview.setVisibility(View.INVISIBLE);
            readReview.setVisibility(View.INVISIBLE);*/




        }



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });






        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);


        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        mFragmentManager = getSupportFragmentManager();

    //    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
    //    fragmentTransaction.replace(R.id.content_frame, new MenuViewPager()).commit();
    //    mCurrentSelectedPosition = 0;


        mDrawerLayout.openDrawer(Gravity.LEFT);


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();


                Log.i(TAG, "nav counter is " + String.valueOf(counter));



                if (menuItem.getItemId() == R.id.menu) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, new MenuViewPager()).commit();
                    mCurrentSelectedPosition = 0;

                    counter++;

                    buttonsInvisible(eat);
                    buttonsInvisible(drink);
                    buttonsInvisible(pickup);




                }

                else if (menuItem.getItemId() == R.id.drinks) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, new DrinksViewPager()).commit();
                    mCurrentSelectedPosition = 1;

                    counter++;

                    buttonsInvisible(eat);
                    buttonsInvisible(drink);
                    buttonsInvisible(pickup);



                }

                else if (menuItem.getItemId() == R.id.pickup) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

                        fragmentTransaction.replace(R.id.content_frame, new PickupListViewFragment(), "PICK_UP_FRAGMENT");
                        fragmentTransaction.addToBackStack("pickup_frag");
                        fragmentTransaction.commit();



                    mCurrentSelectedPosition = 2;

                    counter++;

                    buttonsInvisible(eat);
                    buttonsInvisible(drink);
                    buttonsInvisible(pickup);





                }

                else if (menuItem.getItemId() == R.id.addreview) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, new AddReview()).commit();
                    mCurrentSelectedPosition = 3;

                    counter++;

                    buttonsInvisible(eat);
                    buttonsInvisible(drink);
                    buttonsInvisible(pickup);





                }

                else if (menuItem.getItemId() == R.id.readreview) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, new ReviewListViewFragment()).commit();
                    mCurrentSelectedPosition = 4;

                    counter++;

                    buttonsInvisible(eat);
                    buttonsInvisible(drink);
                    buttonsInvisible(pickup);




                }


                else if (menuItem.getItemId() == R.id.nav_call) {

                    Intent callIntent = new Intent(Intent.ACTION_VIEW);
                    callIntent.setData(Uri.parse("tel:9726777906"));
                    startActivity(callIntent);


                }

                else if (menuItem.getItemId() == R.id.nav_fb) {

                  /*  Intent intent;
                    String FACEBOOK_URL = "https://www.facebook.com/LakewoodSmokehouse";
                    String FACEBOOK_PAGE_ID = "1027584667305709";
                    String FACEBOOK_PAGE_ID_OLD = "fb://page/" + FACEBOOK_PAGE_ID;

                    //method to get the right URL to use in the intent


                        try {
                            int versionCode = getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;
                            if (versionCode >= 3002850) { //newer versions of fb app
                                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(FACEBOOK_URL));
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            } else { //older versions of fb app
                                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(FACEBOOK_PAGE_ID_OLD));
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            }
                        } catch (PackageManager.NameNotFoundException e) {
                            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(FACEBOOK_URL));
                        }
                    startActivity(intent);*/

                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    WebViewFragment webViewFragment = new WebViewFragment();
                    webViewFragment.init("https://www.facebook.com/LakewoodSmokehouse");
                    fragmentTransaction.replace(R.id.content_frame, webViewFragment).commit();
                    mCurrentSelectedPosition = 5;

                }

                else if (menuItem.getItemId() == R.id.nav_ins) {

                  /*  Intent intent = getPackageManager().getLaunchIntentForPackage("com.instagram.android");
                    intent.setComponent(new ComponentName("com.instagram.android", "com.instagram.android.activity.UrlHandlerActivity"));
                    intent.setData(Uri.parse("http://instagram.com/_u/lakewoodsmokehouse"));
                    startActivity(intent);*/

                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    WebViewFragment webViewFragment = new WebViewFragment();
                    webViewFragment.init("http://instagram.com/_u/lakewoodsmokehouse");
                    fragmentTransaction.replace(R.id.content_frame, webViewFragment).commit();
                    mCurrentSelectedPosition = 6;




                }

                else if (menuItem.getItemId() == R.id.nav_tw) {

                   /* Intent intent;
                    String username = "lakewood_bbq";
                    try {
                        // get the Twitter app if possible
                        getPackageManager().getPackageInfo("com.twitter.android", 0);
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + username));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    } catch (Exception e) {
                        // no Twitter app, revert to browser
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/lakewood_bbq"));
                    }
                    startActivity(intent);*/
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    WebViewFragment webViewFragment = new WebViewFragment();
                    webViewFragment.init("https://twitter.com/lakewood_bbq");
                    fragmentTransaction.replace(R.id.content_frame, webViewFragment).commit();
                    mCurrentSelectedPosition = 7;


                }


                return false;
            }


        });

     //   android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);

        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, new MenuViewPager()).commit();
                mCurrentSelectedPosition = 0;

                buttonsInvisible(eat);
                buttonsInvisible(drink);
                buttonsInvisible(pickup);


                counter++;
              //  Log.i("but counter is ", String.valueOf(counter));


            }
        });

        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, new DrinksViewPager()).commit();
                mCurrentSelectedPosition = 1;

                buttonsInvisible(eat);
                buttonsInvisible(drink);
                buttonsInvisible(pickup);


                counter++;
          //      Log.i(" but2 counter is ", String.valueOf(counter));

            }
        });

        pickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, new PickupListViewFragment()).commit();
                mCurrentSelectedPosition = 2;

                buttonsInvisible(eat);
                buttonsInvisible(drink);
                buttonsInvisible(pickup);


                counter++;
            //    Log.i("but3 counter is ", String.valueOf(counter));

            }
        });



    }




    private void buttonsInvisible(View button) {
        button.setVisibility(View.INVISIBLE);

    }


    // Saving the currently selected menu item (index).
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
        outState.putInt(COUNTER, counter);

        Log.i("sis counter is ", String.valueOf(counter));

    }

    public void onResume() {
        super.onResume();


        Log.i("onResume counter is ", String.valueOf(counter));



    }



    // Restoring selected menu item.
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION, 0);
        mNavigationView.getMenu().getItem(mCurrentSelectedPosition).setChecked(true);
        counter = savedInstanceState.getInt(COUNTER);

        Log.i("ris counter is ", String.valueOf(counter));
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mDrawerToggle.syncState();


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }





    @Override
    public void onStart () {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://comapps.com.lakewoodsmokehousend/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop () {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://comapps.com.lakewoodsmokehousend/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ls_icon)
                .setTitle("Leaving us?")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }




    @Override
    protected void attachBaseContext (Context newBase){

        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }


}
