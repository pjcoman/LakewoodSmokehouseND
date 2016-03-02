package comapps.com.lakewoodsmokehousend.reviews;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;

import comapps.com.lakewoodsmokehousend.R;

/**
 * Created by me on 11/7/2015.
 */
public class AddReview extends Fragment {
    private TextView reviewName;
    private RatingBar ratingBar;
    private TextView reviewText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.activity_addreview, container, false);


        Button addButton;
        addButton = (Button) rootView.findViewById(R.id.addButton);
        reviewName = (TextView) rootView.findViewById(R.id.name);
        ratingBar = (RatingBar) rootView.findViewById(R.id.ratingBar);

        Drawable stars = ratingBar.getProgressDrawable();
        stars.setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);


        reviewText = (TextView)rootView.findViewById(R.id.comment);


        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {// TODO Auto-generated method stub

                    ParseObject review = new ParseObject("ls_reviews");
                    review.put("reviewname", reviewName.getText().toString());
                    review.put("rating", String.valueOf(ratingBar.getRating()));
                    review.put("review", reviewText.getText().toString());
                    review.saveInBackground();

                    Toast.makeText(v.getContext(), "New review added", Toast.LENGTH_LONG).show();
                } catch (Exception ignored) {

                }
            }
        });

        return rootView;
    }




    }




