package comapps.com.lakewoodsmokehousend;

import android.app.Application;
import android.util.Log;

import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by me on 10/6/2015.
 */
public class ParseApplication extends Application {

    private static final String TAG = "ParseApplication";


    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(getApplicationContext());

        // Add your initialization code here
        Parse.initialize(this, "3auP8OKsyBVdwDFFhQ7bAINSFldjA0zYrrSiKjIx", "FE0F9uUocCMzPiSyMl0UoEWDT1tdzYs3MOcQwp3O");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

        //   PushService.setDefaultPushCallback(this, MainActivity.class);


        ParseInstallation.getCurrentInstallation().saveInBackground();



        ParseQuery<ParseObject> queryDrinks = new ParseQuery<>(
                "ls_drinks");
        queryDrinks.setLimit(200);


        queryDrinks.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("ls_drinks", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("ls_drinks", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> queryMenu = new ParseQuery<>(
                "ls_menu");
        // Locate the column named "day" in Parse.com and order list
        // by ascending

        queryMenu.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("ls_menu", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("ls_menu", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> queryReviews = new ParseQuery<>(
                "ls_reviews");
        // Locate the column named "day" in Parse.com and order list
        // by ascending

        queryReviews.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("ls_reviews", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("ls_reviews", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> queryGroups = new ParseQuery<>(
                "ls_groups");
        // Locate the column named "day" in Parse.com and order list
        // by ascending

        queryGroups.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("ls_groups", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("ls_groups", object);
                    }
                });
            }
        });



        Log.d(TAG, "App started up");





    }







}
