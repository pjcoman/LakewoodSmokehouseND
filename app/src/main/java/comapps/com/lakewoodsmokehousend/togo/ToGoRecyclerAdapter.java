package comapps.com.lakewoodsmokehousend.togo;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;

import comapps.com.lakewoodsmokehousend.ColoredSnackbar;
import comapps.com.lakewoodsmokehousend.R;
import comapps.com.lakewoodsmokehousend.menu.MenuObject;


/**
 * Created by me on 1/27/2016.
 */
public class ToGoRecyclerAdapter extends RecyclerView.Adapter<ToGoRecyclerAdapter.ViewHolder> {

    private static final String EMPTY_STRING = "";
    private static final String TAG = "TOGORECYCLERADAPTER";
    private final ArrayList<MenuObject> menu;




    private Integer quantity;
    private StringBuilder orderComplete;


    private final String[] meats = {"CHOOSE MEAT", "SLICED BEEF", "CHOPPED BEEF", "PORK", "TURKEY",
            "SAUSAGE", "SAUSAGE{CH)"};

    private final String[] sides = {"CHOOSE SIDE", "CORN BAKE", "MAC N CHEESE", "POTATO SALAD", "GREEN BEANS",
            "OKRA", "FRIES", "BAKED POTATO", "MUSHROOMS", "BBQ BEANS", "COLESLAW"};



    public ToGoRecyclerAdapter(ArrayList<MenuObject> menu, Context context) {


        this.menu = menu;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.togolist_recyclerview_row, parent, false);


        return new ViewHolder(v);

    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {



        final MenuObject orderMenuObject = menu.get(position);
        holder.bind(orderMenuObject);


        switch (orderMenuObject.getGroup()) {
            case "STARTERS":
                holder.ll1.setVisibility(View.VISIBLE);
                holder.rl2.setVisibility(View.GONE);
                holder.ll3.setVisibility(View.GONE);
                holder.llqty.setVisibility(View.VISIBLE);
                holder.buttonminus.setVisibility(View.VISIBLE);
                holder.buttonplus.setVisibility(View.VISIBLE);
                holder.buttonadd.setVisibility(View.GONE);
                holder.buttondelete.setVisibility(View.GONE);
                holder.group.setVisibility(View.VISIBLE);
                holder.ll.setBackgroundResource(R.drawable.layout_rounded_corners_brown);
            //    Log.i(TAG, "The groups is " + orderMenuObject.getGroup());
                break;
            case "SALADS":
                holder.ll1.setVisibility(View.VISIBLE);
                holder.rl2.setVisibility(View.GONE);
                holder.ll3.setVisibility(View.GONE);
                holder.llqty.setVisibility(View.VISIBLE);
                holder.buttonminus.setVisibility(View.VISIBLE);
                holder.buttonplus.setVisibility(View.VISIBLE);
                holder.buttonadd.setVisibility(View.GONE);
                holder.buttondelete.setVisibility(View.GONE);
                holder.group.setVisibility(View.GONE);
                holder.ll.setBackgroundResource(R.drawable.layout_rounded_corners_green);
            //    Log.i(TAG, "The groups is " + orderMenuObject.getGroup());
                break;
            case "TEXAS-SIZED SANDWICHES":
                holder.ll1.setVisibility(View.VISIBLE);
                holder.rl2.setVisibility(View.GONE);
                holder.ll3.setVisibility(View.GONE);
                holder.llqty.setVisibility(View.VISIBLE);
                holder.buttonadd.setVisibility(View.GONE);
                holder.buttondelete.setVisibility(View.GONE);
                holder.group.setVisibility(View.VISIBLE);
                holder.group.setText("SANDWICHES");
                holder.ll.setBackgroundResource(R.drawable.layout_rounded_corners_texasflag);
             //   Log.i(TAG, "The groups is " + orderMenuObject.getGroup());
                break;
            case "SMOKED WINGS":
                holder.ll1.setVisibility(View.VISIBLE);
                holder.rl2.setVisibility(View.GONE);
                holder.ll3.setVisibility(View.GONE);
                holder.llqty.setVisibility(View.VISIBLE);
                holder.buttonminus.setVisibility(View.VISIBLE);
                holder.buttonplus.setVisibility(View.VISIBLE);
                holder.buttonadd.setVisibility(View.GONE);
                holder.buttondelete.setVisibility(View.GONE);
                holder.group.setVisibility(View.GONE);
                holder.ll.setBackgroundResource(R.drawable.layout_rounded_corners_wings);
             //   Log.i(TAG, "The groups is " + orderMenuObject.getGroup());
                break;
            case "HANDCRAFTED PIZZAS":
                holder.ll1.setVisibility(View.VISIBLE);
                holder.rl2.setVisibility(View.GONE);
                holder.ll3.setVisibility(View.GONE);
                holder.llqty.setVisibility(View.VISIBLE);
                holder.buttonminus.setVisibility(View.VISIBLE);
                holder.buttonplus.setVisibility(View.VISIBLE);
                holder.buttonadd.setVisibility(View.GONE);
                holder.buttondelete.setVisibility(View.GONE);
                holder.group.setVisibility(View.VISIBLE);
                holder.group.setText("PIZZA");
                holder.ll.setBackgroundResource(R.drawable.layout_rounded_corners_darkred);
             //   Log.i(TAG, "The groups is " + orderMenuObject.getGroup());
                break;

            case "MEAT":
                holder.rl2.setVisibility(View.VISIBLE);
                holder.ll3.setVisibility(View.VISIBLE);
                holder.item.setText("MEAT PLATES 1, 2 OR 3");
                holder.llqty.setVisibility(View.GONE);
                holder.ll1.setVisibility(View.GONE);
                holder.buttonadd.setVisibility(View.VISIBLE);
                holder.buttondelete.setVisibility(View.VISIBLE);
                holder.ll.setBackgroundResource(R.drawable.layout_rounded_corners_red);
                holder.spinner1.setBackgroundResource(R.drawable.layout_rounded_corners_white);
                holder.spinner2.setBackgroundResource(R.drawable.layout_rounded_corners_white);
                holder.spinner3.setBackgroundResource(R.drawable.layout_rounded_corners_white);
                holder.spinner4.setVisibility(View.GONE);
                holder.spinner5.setVisibility(View.GONE);
                holder.spinner6.setVisibility(View.GONE);
                holder.group.setVisibility(View.GONE);
             //   Log.i(TAG, "The groups is " + orderMenuObject.getGroup());
                break;
            case "BY THE POUND":
                holder.ll1.setVisibility(View.VISIBLE);
                holder.rl2.setVisibility(View.GONE);
                holder.ll3.setVisibility(View.GONE);
                holder.llqty.setVisibility(View.VISIBLE);
                holder.buttonminus.setVisibility(View.VISIBLE);
                holder.buttonplus.setVisibility(View.VISIBLE);
                holder.buttonadd.setVisibility(View.GONE);
                holder.buttondelete.setVisibility(View.GONE);
                holder.group.setVisibility(View.VISIBLE);
                holder.ll.setBackgroundResource(R.drawable.layout_rounded_corners_red);
             //   Log.i(TAG, "The groups is " + orderMenuObject.getGroup());
                break;
            case "SPECIALTIES":
                holder.ll1.setVisibility(View.VISIBLE);
                holder.rl2.setVisibility(View.GONE);
                holder.ll3.setVisibility(View.GONE);
                holder.llqty.setVisibility(View.VISIBLE);
                holder.buttonminus.setVisibility(View.VISIBLE);
                holder.buttonplus.setVisibility(View.VISIBLE);
                holder.buttonadd.setVisibility(View.GONE);
                holder.buttondelete.setVisibility(View.GONE);
                holder.group.setVisibility(View.VISIBLE);
                holder.ll.setBackgroundResource(R.drawable.layout_rounded_corners_yellow);
             //   Log.i(TAG, "The groups is " + orderMenuObject.getGroup());
                break;
            case "KIDS":
                holder.ll1.setVisibility(View.VISIBLE);
                holder.rl2.setVisibility(View.GONE);
                holder.ll3.setVisibility(View.GONE);
                holder.buttonminus.setVisibility(View.VISIBLE);
                holder.buttonplus.setVisibility(View.VISIBLE);
                holder.buttonadd.setVisibility(View.GONE);
                holder.buttondelete.setVisibility(View.GONE);
                holder.group.setVisibility(View.VISIBLE);
                holder.ll.setBackgroundResource(R.drawable.layout_rounded_corners_blue);
             //   Log.i(TAG, "The groups is " + orderMenuObject.getGroup());
                break;
            case "SIDES":
                holder.ll1.setVisibility(View.VISIBLE);
                holder.rl2.setVisibility(View.GONE);
                holder.ll3.setVisibility(View.GONE);
                holder.llqty.setVisibility(View.VISIBLE);
                holder.buttonminus.setVisibility(View.VISIBLE);
                holder.buttonplus.setVisibility(View.VISIBLE);
                holder.buttonadd.setVisibility(View.GONE);
                holder.buttondelete.setVisibility(View.GONE);
                holder.group.setVisibility(View.VISIBLE);
                holder.ll.setBackgroundResource(R.drawable.layout_rounded_corners_brown);
             //   Log.i(TAG, "The groups is " + orderMenuObject.getGroup());
                break;
            case "FAMILY STYLE":
                holder.ll1.setVisibility(View.VISIBLE);
                holder.rl2.setVisibility(View.VISIBLE);
                holder.ll3.setVisibility(View.GONE);
                holder.llqty.setVisibility(View.VISIBLE);
                holder.spinner1.setBackgroundResource(R.drawable.layout_rounded_corners_white);
                holder.spinner2.setBackgroundResource(R.drawable.layout_rounded_corners_white);
                holder.spinner3.setBackgroundResource(R.drawable.layout_rounded_corners_white);
                holder.spinner4.setBackgroundResource(R.drawable.layout_rounded_corners_white);
                holder.spinner5.setBackgroundResource(R.drawable.layout_rounded_corners_white);
                holder.spinner6.setBackgroundResource(R.drawable.layout_rounded_corners_white);
                holder.spinner4.setVisibility(View.VISIBLE);
                holder.spinner5.setVisibility(View.VISIBLE);
                holder.spinner6.setVisibility(View.VISIBLE);
                holder.buttonminus.setVisibility(View.VISIBLE);
                holder.buttonplus.setVisibility(View.VISIBLE);
                holder.buttonadd.setVisibility(View.GONE);
                holder.buttondelete.setVisibility(View.GONE);
                holder.group.setVisibility(View.GONE);
                holder.ll.setBackgroundResource(R.drawable.layout_rounded_corners_red);
             //   Log.i(TAG, "The groups is " + orderMenuObject.getGroup());
                break;


            default:
                holder.ll1.setVisibility(View.VISIBLE);
                holder.rl2.setVisibility(View.GONE);
                holder.ll3.setVisibility(View.GONE);
                holder.llqty.setVisibility(View.VISIBLE);
                holder.buttonminus.setVisibility(View.VISIBLE);
                holder.buttonplus.setVisibility(View.VISIBLE);
                holder.buttonadd.setVisibility(View.GONE);
                holder.buttondelete.setVisibility(View.GONE);
                holder.group.setVisibility(View.GONE);
                holder.ll.setBackgroundResource(R.drawable.layout_rounded_corners_offwhite);

             //   Log.i(TAG, "The group default is " + orderMenuObject.getGroup());
        }

      

        // ********************************************************************************************************



        holder.buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MenuObject orderMenuObject = new MenuObject();
                orderMenuObject.setItem("PLATES");
                orderMenuObject.setGroup("MEAT");
                orderMenuObject.setPrice("$13, $16, $18");
                orderMenuObject.setQuantity(0);
                orderMenuObject.setSelection(0);
                orderMenuObject.setSelection2(0);
                orderMenuObject.setSelection3(0);
                orderMenuObject.setSelection4(0);
                orderMenuObject.setSelection5(0);
                orderMenuObject.setSelection6(0);
                int pos = holder.getAdapterPosition() + 1;
                insert(pos, orderMenuObject);
                notifyItemInserted(pos);

            }
        });

        // ********************************************************************************************************


        holder.buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!orderMenuObject.getItem().equalsIgnoreCase("PLATE")) {

                    remove(holder.getAdapterPosition());

                }

                //   notifyItemRemoved(holder.getAdapterPosition());


            }
        });


        // SPINNERS ********************************************************************************************************

        holder.spinner1.setItems(meats);
        holder.spinner1.setTextSize(12);
        holder.spinner1.setSelectedIndex(orderMenuObject.getSelection());
        holder.spinner1.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                //   Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                orderMenuObject.setSelection(holder.spinner1.getSelectedIndex());


                    if (orderMenuObject.getGroup().equals("MEAT")) {

                        orderMenuObject.setQuantity(1);

                        String m1 = orderMenuObject.getSelection().toString() + orderMenuObject.getSelection2().toString()
                                + orderMenuObject.getSelection3().toString();
                        String findString = "0";
                        String meatItem = String.valueOf(3 - (m1.split(findString, -1).length - 1)) + " MEAT PLATE ";

                        m1 = replacePositionsWithString(m1);

                        orderMenuObject.setOrder(meatItem + m1);
                        String snackBarText = ((orderMenuObject.getItem() + " " + m1 + " added"));

                        Snackbar snackbar = Snackbar.make(view, snackBarText, Snackbar.LENGTH_SHORT);
                        ColoredSnackbar.meat(snackbar).show();

                    } else {

                        if ( orderMenuObject.getQuantity() == 0 ) {
                            orderMenuObject.setQuantity(1);
                        }

                        String m1 = orderMenuObject.getSelection().toString() + orderMenuObject.getSelection2().toString()
                                + orderMenuObject.getSelection3().toString();

                        String s1 = orderMenuObject.getSelection4().toString() + orderMenuObject.getSelection5().toString()
                                + orderMenuObject.getSelection6().toString();


                        m1 = replacePositionsWithString(m1);
                        s1 = replacePositionsWithStringSides(s1);

                        orderMenuObject.setOrder(orderMenuObject.getItem() + m1 + " " + s1 + " qty:" + orderMenuObject.getQuantity().toString());

                        String snackBarText = ((orderMenuObject.getItem() + " " + m1 + " " + s1 + " added"));

                        Snackbar snackbar = Snackbar.make(view, snackBarText, Snackbar.LENGTH_SHORT);
                        ColoredSnackbar.meat(snackbar).show();


                    }


                notifyDataSetChanged();
            }
        });
        holder.spinner2.setItems(meats);
        holder.spinner2.setTextSize(12);
        holder.spinner2.setSelectedIndex(orderMenuObject.getSelection2());
        holder.spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                //    Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                orderMenuObject.setSelection2(holder.spinner2.getSelectedIndex());


                if (orderMenuObject.getGroup().equals("MEAT")) {

                    orderMenuObject.setQuantity(1);

                    String m1 = orderMenuObject.getSelection().toString() + orderMenuObject.getSelection2().toString()
                            + orderMenuObject.getSelection3().toString();
                    String findString = "0";
                    String meatItem = String.valueOf(3 - (m1.split(findString, -1).length - 1)) + " MEAT PLATE ";

                    m1 = replacePositionsWithString(m1);

                    orderMenuObject.setOrder(meatItem + m1);
                    String snackBarText = ((orderMenuObject.getItem() + " " + m1 + " added"));

                    Snackbar snackbar = Snackbar.make(view, snackBarText, Snackbar.LENGTH_SHORT);
                    ColoredSnackbar.meat(snackbar).show();

                } else {

                    if ( orderMenuObject.getQuantity() == 0 ) {
                        orderMenuObject.setQuantity(1);
                    }

                    String m1 = orderMenuObject.getSelection().toString() + orderMenuObject.getSelection2().toString()
                            + orderMenuObject.getSelection3().toString();

                    String s1 = orderMenuObject.getSelection4().toString() + orderMenuObject.getSelection5().toString()
                            + orderMenuObject.getSelection6().toString();


                    m1 = replacePositionsWithString(m1);
                    s1 = replacePositionsWithStringSides(s1);

                    orderMenuObject.setOrder(orderMenuObject.getItem() + m1 + " " + s1 + " qty:" + orderMenuObject.getQuantity().toString());

                    String snackBarText = ((orderMenuObject.getItem() + " " + m1 + " " + s1 + " added"));
                    Snackbar snackbar = Snackbar.make(view, snackBarText, Snackbar.LENGTH_SHORT);
                    ColoredSnackbar.meat(snackbar).show();


                }

                notifyDataSetChanged();
            }
        });
        holder.spinner3.setItems(meats);
        holder.spinner3.setTextSize(12);
        holder.spinner3.setSelectedIndex(orderMenuObject.getSelection3());
        holder.spinner3.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                //   Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                orderMenuObject.setSelection3(holder.spinner3.getSelectedIndex());


                Log.i(TAG, orderMenuObject.getGroup());

                if (orderMenuObject.getGroup().equals("MEAT")) {

                    orderMenuObject.setQuantity(1);

                    String m1 = orderMenuObject.getSelection().toString() + orderMenuObject.getSelection2().toString()
                            + orderMenuObject.getSelection3().toString();
                    String findString = "0";
                    String meatItem = String.valueOf(3 - (m1.split(findString, -1).length - 1)) + " MEAT PLATE ";

                    m1 = replacePositionsWithString(m1);


                    orderMenuObject.setOrder(meatItem + m1);
                    String snackBarText = ((orderMenuObject.getItem() + " " + m1 + " added"));

                    Snackbar snackbar = Snackbar.make(view, snackBarText, Snackbar.LENGTH_SHORT);
                    ColoredSnackbar.meat(snackbar).show();


                } else {

                    if ( orderMenuObject.getQuantity() == 0 ) {
                        orderMenuObject.setQuantity(1);
                    }

                    String m1 = orderMenuObject.getSelection().toString() + orderMenuObject.getSelection2().toString()
                            + orderMenuObject.getSelection3().toString();

                    String s1 = orderMenuObject.getSelection4().toString() + orderMenuObject.getSelection5().toString()
                            + orderMenuObject.getSelection6().toString();


                    m1 = replacePositionsWithString(m1);
                    s1 = replacePositionsWithStringSides(s1);

                    orderMenuObject.setOrder(orderMenuObject.getItem() + m1 + " " + s1 + " qty:" + orderMenuObject.getQuantity().toString());

                    String snackBarText = ((orderMenuObject.getItem() + " " + m1 + " " + s1 + " added"));

                    Snackbar snackbar = Snackbar.make(view, snackBarText, Snackbar.LENGTH_SHORT);
                    ColoredSnackbar.meat(snackbar).show();


                }

                notifyDataSetChanged();

            }
        });



        holder.spinner4.setItems(sides);
        holder.spinner4.setTextSize(12);
        holder.spinner4.setSelectedIndex(orderMenuObject.getSelection4());
        holder.spinner4.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                //   Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                orderMenuObject.setSelection4(holder.spinner4.getSelectedIndex());

                if ( orderMenuObject.getQuantity() == 0 ) {
                    orderMenuObject.setQuantity(1);
                }

                String m1 = orderMenuObject.getSelection().toString() + orderMenuObject.getSelection2().toString()
                        + orderMenuObject.getSelection3().toString();

                String s1 = orderMenuObject.getSelection4().toString() + orderMenuObject.getSelection5().toString()
                        + orderMenuObject.getSelection6().toString();

                m1 = replacePositionsWithString(m1);
                s1 = replacePositionsWithStringSides(s1);

                orderMenuObject.setOrder(orderMenuObject.getItem() + m1 + " " + s1 + " qty:" + orderMenuObject.getQuantity().toString());

                String snackBarText = ((orderMenuObject.getItem() + " " + m1 + " " + s1 + " added"));

                Snackbar snackbar = Snackbar.make(view, snackBarText, Snackbar.LENGTH_SHORT);
                ColoredSnackbar.meat(snackbar).show();



                notifyDataSetChanged();

            }
        });

        holder.spinner5.setItems(sides);
        holder.spinner5.setTextSize(12);
        holder.spinner5.setSelectedIndex(orderMenuObject.getSelection5());
        holder.spinner5.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                //   Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                orderMenuObject.setSelection5(holder.spinner5.getSelectedIndex());

                if ( orderMenuObject.getQuantity() == 0 ) {
                    orderMenuObject.setQuantity(1);
                }

                String m1 = orderMenuObject.getSelection().toString() + orderMenuObject.getSelection2().toString()
                        + orderMenuObject.getSelection3().toString();

                String s1 = orderMenuObject.getSelection4().toString() + orderMenuObject.getSelection5().toString()
                        + orderMenuObject.getSelection6().toString();

                m1 = replacePositionsWithString(m1);
                s1 = replacePositionsWithStringSides(s1);

                orderMenuObject.setOrder(orderMenuObject.getItem() + m1 + " " + s1 + " qty:" + orderMenuObject.getQuantity().toString());

                String snackBarText = ((orderMenuObject.getItem() + " " + m1 + " " + s1 + " added"));

                Snackbar snackbar = Snackbar.make(view, snackBarText, Snackbar.LENGTH_SHORT);
                ColoredSnackbar.meat(snackbar).show();
                notifyDataSetChanged();

            }
        });

        holder.spinner6.setItems(sides);
        holder.spinner6.setTextSize(12);
        holder.spinner6.setSelectedIndex(orderMenuObject.getSelection6());
        holder.spinner6.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                //   Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                orderMenuObject.setSelection6(holder.spinner6.getSelectedIndex());

                if ( orderMenuObject.getQuantity() == 0 ) {
                    orderMenuObject.setQuantity(1);
                }

                String m1 = orderMenuObject.getSelection().toString() + orderMenuObject.getSelection2().toString()
                        + orderMenuObject.getSelection3().toString();

                String s1 = orderMenuObject.getSelection4().toString() + orderMenuObject.getSelection5().toString()
                        + orderMenuObject.getSelection6().toString();

                m1 = replacePositionsWithString(m1);
                s1 = replacePositionsWithStringSides(s1);

                orderMenuObject.setOrder(orderMenuObject.getItem() + m1 + " " + s1 + " qty:" + orderMenuObject.getQuantity().toString());

                String snackBarText = ((orderMenuObject.getItem() + " " + m1 + " " + s1 + " added"));

                Snackbar snackbar = Snackbar.make(view, snackBarText, Snackbar.LENGTH_SHORT);
                ColoredSnackbar.meat(snackbar).show();

                notifyDataSetChanged();

            }
        });


        // SPINNERS ********************************************************************************************************


        holder.buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.buttonminus.setEnabled(true);
                quantity = orderMenuObject.getQuantity();
                quantity = quantity + 1;
                orderMenuObject.setQuantity(quantity);

                menu.get(position).setQuantity(quantity);

                Log.i(TAG, orderMenuObject.getItem());

                Log.i(TAG, orderMenuObject.getQuantity().toString());

                if ( orderMenuObject.getItem().equals("FAMILY STYLE")) {

                    Log.i(TAG, "FAMILY STYLE +");

                    String m1 = orderMenuObject.getSelection().toString() + orderMenuObject.getSelection2().toString()
                            + orderMenuObject.getSelection3().toString();

                    String s1 = orderMenuObject.getSelection4().toString() + orderMenuObject.getSelection5().toString()
                            + orderMenuObject.getSelection6().toString();

                    m1 = replacePositionsWithString(m1);
                    s1 = replacePositionsWithStringSides(s1);


                    orderMenuObject.setOrder(orderMenuObject.getItem() + m1 + " " + s1 + " qty:" + orderMenuObject.getQuantity().toString());




                } else {

                    orderMenuObject.setOrder(orderMenuObject.getItem() + " qty:" + orderMenuObject.getQuantity().toString());

                }

                holder.quantity.setText(quantity.toString());
                Snackbar snackbar = Snackbar.make(v, orderMenuObject.getItem() + " added", Snackbar.LENGTH_SHORT);
           //     Snackbar.make(v, orderMenuObject.getItem() + " added", Snackbar.LENGTH_LONG).show();
                ColoredSnackbar.meat(snackbar).show();
                notifyDataSetChanged();


            }
        });

        // ********************************************************************************************************


        holder.buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (orderMenuObject.getGroup().equalsIgnoreCase("MEAT")) {
                    orderMenuObject.setSelection(0);
                    orderMenuObject.setSelection2(0);
                    orderMenuObject.setSelection3(0);
                    orderMenuObject.setQuantity(0);
                    holder.buttonminus.setEnabled(false);
                    holder.quantity.setText("0");

                } else {

                    quantity = orderMenuObject.getQuantity();



                    quantity--;

                    if (quantity < 1) {
                        quantity = 0;


                    }



                    orderMenuObject.setQuantity(quantity);
                    menu.get(position).setQuantity(quantity);

                    if (orderMenuObject.getItem().equals("FAMILY STYLE")) {

                        String m1 = orderMenuObject.getSelection().toString() + orderMenuObject.getSelection2().toString()
                                + orderMenuObject.getSelection3().toString();

                        String s1 = orderMenuObject.getSelection4().toString() + orderMenuObject.getSelection5().toString()
                                + orderMenuObject.getSelection6().toString();

                        m1 = replacePositionsWithString(m1);
                        s1 = replacePositionsWithStringSides(s1);

                        orderMenuObject.setOrder(orderMenuObject.getItem() + m1 + " " + s1 + " qty:" + orderMenuObject.getQuantity().toString());


                    } else {


                        orderMenuObject.setOrder(orderMenuObject.getItem() + " (" + orderMenuObject.getQuantity().toString() + ")");

                    }



                }
                Snackbar.make(v, orderMenuObject.getItem() + " removed", Snackbar.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });

        // ********************************************************************************************************



        holder.quantity.setText(orderMenuObject.getQuantity().toString());


        if (holder.spinner1.getText() == "CHOOSE MEAT") {
            holder.spinner1.setTag("0");
        } else {
            holder.spinner1.setTag("1");



        }
        if (holder.spinner1.getText() == "CHOOSE MEAT") {
            holder.spinner2.setTag("0");
        } else {
            holder.spinner2.setTag("1");


        }
        if (holder.spinner1.getText() == "CHOOSE MEAT") {
            holder.spinner3.setTag("0");
        } else {
            holder.spinner3.setTag("1");


        }


        Integer qty = (Integer.valueOf(holder.spinner1.getTag().toString()) + Integer.valueOf(holder.spinner2.getTag().toString()) +
                Integer.valueOf(holder.spinner3.getTag().toString()));


        String price = (String) holder.price.getText();


        if (orderMenuObject.getGroup().equalsIgnoreCase("MEAT")) {


            String[] priceArray = price.split(", ");


            switch (qty) {
                case 0:
                    if (orderMenuObject.getGroup().contains("CHOOSE MEAT")) {
                        orderMenuObject.setQuantity(0);
                        holder.quantity.setText("0");

                    }
                    break;
                case 1:
                    holder.price.setText(priceArray[0]);

                    break;
                case 2:
                    holder.price.setText(priceArray[1]);

                    break;
                case 3:
                    holder.price.setText(priceArray[2]);

                    break;
                default:
            }

        }


            if (orderMenuObject.getQuantity() < 1) {
                holder.buttonminus.setEnabled(false);
            } else {
                holder.buttonminus.setEnabled(true);
            }


            orderComplete = new StringBuilder();
        //    orderComplete.append(" -> ");

            int total = 0;

            for (int i = 0; i < menu.size(); i++) {
                if (menu.get(i).getQuantity() > 0) {


                        String orderItem = menu.get(i).getOrder().trim();


                    Log.i(TAG, "Order item " + orderItem);

                    String pFinal;
                    String p = menu.get(i).getPrice();
                    String pFirstChar = String.valueOf((menu.get(i).getOrder()).charAt(0));

                   // Log.i(TAG, "op 1st character is " + pFirstChar);

                  //  Log.i(TAG, p);

                  //  Log.i(TAG, menu.get(i).getGroup());

                    p = p.replace("$", "");
                  //  Log.i(TAG, p);
                    p = p.replace("GF", "").trim();
                  //  Log.i(TAG, p);
                    p = p.replace(", ", "");
                  //  Log.i(TAG, p);
                    p = p.replace("per person", "").trim();
                  //  Log.i(TAG, p);
                  //  Log.i(TAG, pFirstChar);




                    switch (pFirstChar) {
                        case "1":
                            pFinal = p.substring(0, 2).trim();
                            break;
                        case "2":
                            pFinal = p.substring(2, 4).trim();
                            break;
                        case "3":
                            pFinal = p.substring(4, 6).trim();
                            break;
                        default:
                            pFinal = p.trim();




                    }


                    int integerP = Integer.parseInt(pFinal);
                    int q = menu.get(i).getQuantity();
                    int subTotal = q * integerP;


                    total = total + subTotal;

                    orderComplete.append(orderItem);
                    orderComplete.append(" $").append(pFinal);
                    orderComplete.append(System.getProperty("line.separator"));
                }

            //    Log.i(TAG, "total " + total);

            }

            orderComplete.append(System.getProperty("line.separator"));

            orderComplete.append("total");
            orderComplete.append(" -> $").append(total).append(" <-");

        Log.i(TAG, orderComplete.toString());



        }




    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return menu.size();
    }


    public String
    getOrder() {
        //returns the number of elements the RecyclerView will display
        return orderComplete.toString();
    }

    public ArrayList<MenuObject>
    getOrderList() {
        //returns the number of elements the RecyclerView will display
        return menu;
    }


    // Insert a new item to the RecyclerView on a predefined position
    private void insert(int position, MenuObject menuObject) {
        menu.add(position, menuObject);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    private void remove(int position) {
        //  int position = menuObjectList.indexOf(menuObject);
        menu.remove(position);
        notifyItemRemoved(position);

    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public final LinearLayout ll;
        public final TextView item;
        public final TextView group;
        public final TextView price;
        public final TextView quantity;
        public final ImageButton buttonplus;
        public final ImageButton buttonminus;
        public final ImageButton buttonadd;
        public final ImageButton buttondelete;
        public final LinearLayout ll1;
        public final RelativeLayout rl2;
        public final LinearLayout ll3;
        public final MaterialSpinner spinner1;
        public final MaterialSpinner spinner2;
        public final MaterialSpinner spinner3;
        public final MaterialSpinner spinner4;
        public final MaterialSpinner spinner5;
        public final MaterialSpinner spinner6;
        public final TextView tvqty;
        public final LinearLayout llfood;
        public final LinearLayout llqty;


        ViewHolder(View itemView) {
            super(itemView);
            ll = (LinearLayout) itemView.findViewById(R.id.ll);
            item = (TextView) itemView.findViewById(R.id.item);
            group = (TextView) itemView.findViewById(R.id.group);
            price = (TextView) itemView.findViewById(R.id.price);
            quantity = (TextView) itemView.findViewById(R.id.quantity);
            buttonplus = (ImageButton) itemView.findViewById(R.id.buttonplus);
            buttonminus = (ImageButton) itemView.findViewById(R.id.buttonminus);
            buttonadd = (ImageButton) itemView.findViewById(R.id.imageButtonAdd);
            buttondelete = (ImageButton) itemView.findViewById(R.id.imageButtonDelete);
            ll1 = (LinearLayout) itemView.findViewById(R.id.ll1);
            rl2 = (RelativeLayout) itemView.findViewById(R.id.ll2);
            ll3 = (LinearLayout) itemView.findViewById(R.id.ll3);
            spinner1 = (MaterialSpinner) itemView.findViewById(R.id.spinner1);
            spinner2 = (MaterialSpinner) itemView.findViewById(R.id.spinner2);
            spinner3 = (MaterialSpinner) itemView.findViewById(R.id.spinner3);
            spinner4 = (MaterialSpinner) itemView.findViewById(R.id.spinner4);
            spinner5 = (MaterialSpinner) itemView.findViewById(R.id.spinner5);
            spinner6 = (MaterialSpinner) itemView.findViewById(R.id.spinner6);
            tvqty = (TextView) itemView.findViewById(R.id.textViewQty);
            llfood = (LinearLayout) itemView.findViewById(R.id.llfood);
            llqty = (LinearLayout) itemView.findViewById(R.id.llqty);


        }

        public void bind(MenuObject orderMenuObject) {

            item.setText(orderMenuObject.getItem());
            Log.i(TAG, orderMenuObject.getItem());
            group.setText(orderMenuObject.getGroup());
            price.setText(orderMenuObject.getPrice());
            Log.i(TAG, orderMenuObject.getPrice());
            quantity.setText(orderMenuObject.getQuantity().toString());


        }




    }



    private static String replacePositionsWithString(String meatPosition) {

        meatPosition = meatPosition.replaceAll("0", "");
        meatPosition = meatPosition.replaceAll("1", "|SLICED BEEF|");
        meatPosition = meatPosition.replaceAll("2", "|CHOPPED BEEF|");
        meatPosition = meatPosition.replaceAll("3", "|PORK|");
        meatPosition = meatPosition.replaceAll("4", "|TURKEY|");
        meatPosition = meatPosition.replaceAll("5", "|SAUSAGE|");
        meatPosition = meatPosition.replaceAll("6", "|CHEDDAR SAUASAGE|");
        return (meatPosition);
    }

    private static String replacePositionsWithStringSides(String sidePosition) {

        sidePosition = sidePosition.replaceAll("0", "");
        sidePosition = sidePosition.replaceAll("1", "|CORN BAKE|");
        sidePosition = sidePosition.replaceAll("2", "|MAC N CHEESE|");
        sidePosition = sidePosition.replaceAll("3", "|POTATO SALAD|");
        sidePosition = sidePosition.replaceAll("4", "|GREEN BEANS|");
        sidePosition = sidePosition.replaceAll("5", "|OKRA|");
        sidePosition = sidePosition.replaceAll("6", "|FRIES|");
        sidePosition = sidePosition.replaceAll("7", "|BAKED POTATO|");
        sidePosition = sidePosition.replaceAll("8", "|MUSHROOMS|");
        sidePosition = sidePosition.replaceAll("9", "|BBQ BEANS|");
        sidePosition = sidePosition.replaceAll("10", "|COLESLAW|");
        return (sidePosition);
    }



}





