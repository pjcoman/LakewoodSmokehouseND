package comapps.com.lakewoodsmokehousend.reviews;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

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
public class ReviewListViewFragment extends ListFragment {

    private BackendlessCollection<Review> reviews;
    private List<Review> totalReviews = new ArrayList<>();
    private boolean isLoadingItems = false;
    private ReviewListViewAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.reviewlistfragment, container, false);
        ListView list = (ListView) rootView.findViewById(android.R.id.list);

        list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        return rootView;
    }


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


/*


        List<ParseObject> ob;

        try {
            // Locate the class table named "stansbeers" in Parse.com
            ParseQuery<ParseObject> query = new ParseQuery<>(
                    "ls_reviews").fromLocalDatastore();
            // Locate the column named "name" in Parse.com and order list
            // by ascending

            query.orderByDescending("createdAt");


            ob = query.find();



            totalReviews = new ArrayList<>();

            for (ParseObject reviews : ob) {
                // Locate images in flag column




                ReviewListObject review = new ReviewListObject();
                review.setReviewName((String) reviews.get("reviewname"));
                review.setReviewRating((String) reviews.get("rating"));
                String rating = ((String) reviews.get("rating"));
                review.setReview((String) reviews.get("review"));

                int firstDigitOfRating = Integer.valueOf(rating.substring(0,1));

                if ( firstDigitOfRating > 2 ) { totalReviews.add(review);
                }
            }


        } catch (ParseException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }*/

        adapter = new ReviewListViewAdapter(getActivity(), totalReviews);
        setListAdapter(adapter);

        QueryOptions queryOptions = new QueryOptions();
        queryOptions.setPageSize(100);
        BackendlessDataQuery query = new BackendlessDataQuery();
        query.setQueryOptions(queryOptions);
        String whereClause = "rating LIKE '3.0' OR rating LIKE '3.5' OR rating LIKE '4.0' OR rating LIKE '4.5' OR rating LIKE '5.0'";
        query.setWhereClause( whereClause );

        Backendless.Data.of( Review.class ).find( query, new LoadingCallback<BackendlessCollection<Review>>
                ( getActivity(), "Loading reviews...", true) {

            @Override
        public void handleResponse(BackendlessCollection<Review> reviewsBackendlessCollection ) {
                reviews = reviewsBackendlessCollection;
                addMoreItems( reviewsBackendlessCollection);
                super.handleResponse( reviewsBackendlessCollection);
            }

        } );

        adapter.notifyDataSetChanged();

    }

    private void addMoreItems( BackendlessCollection<Review> nextPage) {
        totalReviews.addAll( nextPage.getCurrentPage());
        adapter.notifyDataSetChanged();

    }




    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDivider(new ColorDrawable(Color.BLACK));
        getListView().setDividerHeight(5);
    }
}



