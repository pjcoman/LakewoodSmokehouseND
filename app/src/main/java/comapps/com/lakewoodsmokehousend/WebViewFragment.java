package comapps.com.lakewoodsmokehousend;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by me on 2/26/2016.
 */
public class WebViewFragment extends Fragment {

    private String currentURL;

    public void init(String url) {
        currentURL = url;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("SwA", "WVF onCreateView");
        View v = inflater.inflate(R.layout.webfragmet, container, false);
        if (currentURL != null) {
            Log.d("SwA", "Current URL  1["+currentURL+"]");

            WebView wv = (WebView) v.findViewById(R.id.webView2);
            wv.getSettings().setJavaScriptEnabled(true);
            wv.setWebViewClient(new SwAWebClient());
            wv.loadUrl(currentURL);

        }
        return v;
    }

    public void updateUrl(String url) {
        Log.d("SwA", "Update URL ["+url+"] - View ["+getView()+"]");
        currentURL = url;

        WebView wv = (WebView) getView().findViewById(R.id.webView2);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url);

    }

    private class SwAWebClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }

    }

}