package comapps.com.lakewoodsmokehousend;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Map;

/**
 * Created by me on 2/11/2016.
 */
public class MySharedPreferences {

    private final SharedPreferences pref;
    private final SharedPreferences.Editor editor;

    private static final String PREF_NAME = "pref";
    private static final String ORDER_ITEMS = "orderitems";


    public MySharedPreferences(Context context) {
        int PRIVATE_MODE = 0;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void saveOrderItemsList(String orderItemString) {
        editor.putString(ORDER_ITEMS, orderItemString);
        editor.commit();

        Map<String,?> keys = pref.getAll();

        for(Map.Entry<String,?> entry : keys.entrySet()){
            Log.d("order SP ",entry.getKey() + ": " + entry.getValue().toString());
        }
    }




    public String getOrderItemsList()
    {

        return pref.getString(ORDER_ITEMS, "");
    }


}
