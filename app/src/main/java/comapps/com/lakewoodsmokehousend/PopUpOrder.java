package comapps.com.lakewoodsmokehousend;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by me on 3/2/2016.
 */
public class PopUpOrder extends Activity implements
        TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener
         {

    private static final String TAG = "POPUPORDER";
    TextView orderTV;
    String order;
    Intent so;
    Intent chooser;
    String time;
    String date;



    private TextView timeTextView;
    private TextView dateTextView;
    private CheckBox mode24Hours;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MerriweatherSans-Italic.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        setContentView(R.layout.popuporder);

        final Button sendOrder = (Button) findViewById(R.id.buttonSo);
        timeTextView = (TextView)findViewById(R.id.time_textview);
        dateTextView = (TextView)findViewById(R.id.date_textview);
        Button timeButton = (Button)findViewById(R.id.time_button);
        Button dateButton = (Button)findViewById(R.id.date_button);

        mode24Hours = (CheckBox)findViewById(R.id.mode_24_hours);

        mode24Hours.setChecked(false);



        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.85),(int)(height*.9));
        getWindow().setGravity(Gravity.BOTTOM);

        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        Intent intent = getIntent();
        order = intent.getExtras().getString("order");

       /* sv = (ScrollView) findViewById(R.id.scrollView);
        sv.fullScroll(View.FOCUS_DOWN);*/
        orderTV = (TextView) findViewById(R.id.textViewOrder);
        orderTV.setMovementMethod(new ScrollingMovementMethod());
        orderTV.setVerticalScrollBarEnabled(true);
        orderTV.setVerticalFadingEdgeEnabled(false);
        orderTV.setText(order);

        sendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (order.isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "order is empty", Toast.LENGTH_LONG);
                    LinearLayout toastLayout = (LinearLayout) toast.getView();
                    TextView toastTV = (TextView) toastLayout.getChildAt(0);
                    toastTV.setTextSize(12);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                } else {

                    so = new Intent(Intent.ACTION_SEND);
                    so.setData(Uri.parse("mailto:"));
                    so.setType("message/rfc822");
                    String[] send_to = {"email.pete@yahoo.com", "evil_chopsticks@yahoo.com"};
                    so.putExtra(Intent.EXTRA_EMAIL, send_to);
                    //  blind carbon copy
                    //  intent.putExtra(Intent.EXTRA_BCC, address);
                    //  carbon copy
                    //  intent.putExtra(Intent.EXTRA_CC, address);

                    TelephonyManager tMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
                    String mPhoneNumber = tMgr.getLine1Number();

                    StringBuilder splitPhoneNum = new StringBuilder(mPhoneNumber);
                    String ac = splitPhoneNum.substring(0, 3);
                    String nxx = splitPhoneNum.substring(3, 6);
                    String xxxx = splitPhoneNum.substring(6);


                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                    String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/lwsmokehouseicon.jpg";
                    OutputStream out = null;
                    File file = new File(path);
                    try {
                        out = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                        out.flush();
                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    path = file.getPath();
                    Uri bmpUri = Uri.parse("file://" + path);
                    so.putExtra(Intent.EXTRA_SUBJECT, "ORDER FOR PICKUP from " + "(" + ac + ")" + nxx + "-" + xxxx);
                    so.putExtra(Intent.EXTRA_TEXT, order + System.getProperty("line.separator") + date +
                            System.getProperty("line.separator") + time);

                    Log.i(TAG, "email text" + date + time);

                    so.putExtra(Intent.EXTRA_STREAM, bmpUri);

                    chooser = Intent.createChooser(so, "Select Email app...");
                    chooser = Intent.createChooser(so, "");

                    if (so.resolveActivity(getApplicationContext().getPackageManager()) != null) {
                        startActivity(chooser);


                    }


                }
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        PopUpOrder.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        mode24Hours.isChecked()
                );
               /* tpd.setThemeDark(modeDarkTime.isChecked());
                tpd.vibrate(vibrateTime.isChecked());
                tpd.dismissOnPause(dismissTime.isChecked());
                tpd.enableSeconds(enableSeconds.isChecked());
                if (modeCustomAccentTime.isChecked()) {
                    tpd.setAccentColor(Color.parseColor("#9C27B0"));
                }
                if (titleTime.isChecked()) {
                    tpd.setTitle("TimePicker Title");
                }
                if (limitTimes.isChecked()) {
                    tpd.setTimeInterval(2, 5, 10);
                }*/
                tpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        Log.d("TimePicker", "Dialog was cancelled");
                    }
                });
                tpd.show(getFragmentManager(), "Timepickerdialog");
            }
        });

        // Show a datepicker when the dateButton is clicked
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        PopUpOrder.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
               /* dpd.setThemeDark(modeDarkDate.isChecked());
                dpd.vibrate(vibrateDate.isChecked());
                dpd.dismissOnPause(dismissDate.isChecked());
                dpd.showYearPickerFirst(showYearFirst.isChecked());
                if (modeCustomAccentDate.isChecked()) {
                    dpd.setAccentColor(Color.parseColor("#9C27B0"));
                }
                if (titleDate.isChecked()) {
                    dpd.setTitle("DatePicker Title");
                }
                if (limitDates.isChecked()) {
                    Calendar[] dates = new Calendar[13];
                    for(int i = -6; i <= 6; i++) {
                        Calendar date = Calendar.getInstance();
                        date.add(Calendar.MONTH, i);
                        dates[i+6] = date;
                    }
                    dpd.setSelectableDays(dates);
                }
                if (highlightDates.isChecked()) {
                    Calendar[] dates = new Calendar[13];
                    for(int i = -6; i <= 6; i++) {
                        Calendar date = Calendar.getInstance();
                        date.add(Calendar.WEEK_OF_YEAR, i);
                        dates[i+6] = date;
                    }
                    dpd.setHighlightedDays(dates);
                }*/
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

        }

    @Override
    protected void attachBaseContext (Context newBase){

        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }





             @Override
             public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {



               //  date = dayOfMonth+"/"+(++monthOfYear)+"/"+year;
                 date = (++monthOfYear) + "/" + dayOfMonth + "/" + year;
                 dateTextView.setText(date);

                 Log.i(TAG, date);





             }

             @Override
             public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {

                 String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
                 String minuteString = minute < 10 ? "0" + minute : "" + minute;

                 if ( hourOfDay == 12 ) {
                    time = hourString + ":" + minuteString + "pm";
                 } else if ( hourOfDay > 12 ) {

                     time = String.valueOf(hourOfDay - 12) + ":" + minuteString + "pm";

                 } else {
                     time = hourString + ":" + minuteString + "am";
                 }


                 timeTextView.setText(time);

             }

             @Override
             public void onSaveInstanceState(Bundle savedInstanceState) {
                 super.onSaveInstanceState(savedInstanceState);

                 CharSequence dateToPass = dateTextView.getText();
                 CharSequence timeToPass = timeTextView.getText();

                 Log.i(TAG, dateToPass.toString());
                 Log.i(TAG, timeToPass.toString());
                 savedInstanceState.putString("Date", dateToPass.toString());
                 savedInstanceState.putString("Time", timeToPass.toString());




             }

             @Override
             public void onRestoreInstanceState(Bundle savedInstanceState) {
                 super.onRestoreInstanceState(savedInstanceState);


                 String timeToPass = savedInstanceState.getString("Time");
                 Log.i(TAG, timeToPass);
                 timeTextView.setText(timeToPass);
                 time = timeToPass;
                 String dateToPass = savedInstanceState.getString("Date");
                 Log.i(TAG, dateToPass);
                 dateTextView.setText(dateToPass);
                 date = dateToPass;

             }
         }


