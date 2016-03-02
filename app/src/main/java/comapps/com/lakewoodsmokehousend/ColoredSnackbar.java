package comapps.com.lakewoodsmokehousend;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by me on 2/15/2016.
 */
public class ColoredSnackbar {

    private static final int red = 0xbce00025;
    private static final int green = 0xbc7fa016;
    private static final int blue = 0xff2195f3;
    private static final int orange = 0xffffc107;
    private static final int black = 0xff000000;

    private static View getSnackBarLayout(Snackbar snackbar) {
        if (snackbar != null) {
            return snackbar.getView();
        }
        return null;
    }

    private static Snackbar colorSnackBar(Snackbar snackbar, int colorId) {
        View snackBarView = getSnackBarLayout(snackbar);
        if (snackBarView != null) {
            snackBarView.setBackgroundColor(colorId);
        }

        return snackbar;
    }

    public static Snackbar info(Snackbar snackbar) {
        return colorSnackBar(snackbar, blue);
    }

    public static Snackbar warning(Snackbar snackbar) {
        return colorSnackBar(snackbar, orange);
    }

    public static Snackbar meat(Snackbar snackbar) {
        return colorSnackBar(snackbar, black);
    }

    public static Snackbar salad(Snackbar snackbar) {
        return colorSnackBar(snackbar, black);
    }
}
