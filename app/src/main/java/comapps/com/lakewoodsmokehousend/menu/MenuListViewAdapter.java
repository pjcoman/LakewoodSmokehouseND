package comapps.com.lakewoodsmokehousend.menu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import comapps.com.lakewoodsmokehousend.R;


class MenuListViewAdapter extends BaseAdapter {

    private static final String TAG = "MENULISTVIEWADAPTER ";


    private final Context context;
    private final List<Menu> menu;


    public MenuListViewAdapter(Context context, List<Menu> menu) {

        this.context = context;
        this.menu = menu;

    }


    @Override
    public int getCount() {
        return menu.size();
    }

    @Override
    public Object getItem(int position) {
        return menu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;


        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.menulistrow, parent, false);

            holder = new ViewHolder();
            holder.item = (TextView) view.findViewById(R.id.itemTxt);
            holder.price = (TextView) view.findViewById(R.id.priceTxt);
            holder.description = (TextView) view.findViewById(R.id.descriptionTxt);


            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // S
        //
        Menu menuItem = menu.get(position);

        holder.item.setText(menuItem.getItem());
        holder.price.setText(menuItem.getPrice());

        if (menuItem.getDescription() != null) {
            holder.description.setText(menuItem.getDescription().trim());
        }

        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/MerriweatherSans-Italic.ttf");
        holder.item.setTypeface(font);
        holder.price.setTypeface(font);
        holder.description.setTypeface(font);



        String text = menuItem.getGroup();


        switch (text) {
            case ("BY THE POUND"):
                holder.description.setVisibility(View.GONE);
                break;
            case ("KIDS"):
                holder.price.setVisibility(View.INVISIBLE);
                if (position != 0) {holder.price.setVisibility(View.GONE);}
                break;
            case ("SIDES"):
                if (position != 0) {holder.price.setVisibility(View.GONE); holder.description.setVisibility(View.GONE);}
                break;
            default:
                Log.v(TAG, "Not KIDS or SIDES " + text);
                holder.price.setVisibility(View.VISIBLE);
                String description = (String) holder.description.getText();
                if (description.isEmpty()) {
                    holder.description.setVisibility(View.GONE);
                } else {
                    holder.description.setVisibility(View.VISIBLE);
                }

        }


        return view;


    }


    public class ViewHolder {
        TextView item;
        TextView price;
        TextView description;

    }


}