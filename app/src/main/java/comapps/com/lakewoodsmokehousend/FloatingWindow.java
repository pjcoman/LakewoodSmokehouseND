package comapps.com.lakewoodsmokehousend;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by me on 3/4/2016.
 */
public class FloatingWindow extends Service {

    private WindowManager wm;
    private LinearLayout ll;

    @Override

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();

        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        ll = new LinearLayout(this);
    }
}
