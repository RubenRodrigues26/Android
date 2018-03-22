package com.example.ruben.assingment2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ruben.assingment2.LiteSQL.LiteSQLActivity;

public class MainActivity extends Activity implements GestureDetector.OnGestureListener{

    private Spinner spinner1;
    private TextView tv, tv1;
    private SeekBar sb;
    private GestureDetectorCompat detector;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnSpinnerItemSelection();

        //Menu and context menu
        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnCreateContextMenuListener(this);

        tv = (TextView) findViewById(R.id.value);
        tv1 = (TextView) findViewById(R.id.textValue);
        sb = (SeekBar) findViewById(R.id.seekBar);

        detector = new GestureDetectorCompat(this, this);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                tv.setTextSize(progress);
                tv1.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar){

            }
        });

        // programatically add a widget
        LinearLayout layout = (LinearLayout) findViewById(R.id.linLayoutID);
        layout.setBackgroundColor(Color.DKGRAY);

        // Create a custom widget and add
        View customView = new CustomWidget(this);
        customView.setTag("customTag"); // Optional tag
        layout.addView(customView, 1100, 600); // add & specify it's size

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        CharSequence notiText = "Your notification from the service";
        long meow = System.currentTimeMillis();

        Notification notification = new Notification(R.drawable.ic_launcher_background, notiText, meow);

        Context context = getApplicationContext();
        CharSequence contentTitle = "Your notification";
        CharSequence contentText = "Some data has arrived!";
        Intent notificationIntent = new Intent(this, LiteSQLActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        int SERVER_DATA_RECEIVED = 1;
        notificationManager.notify(SERVER_DATA_RECEIVED, notification);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void addListenerOnSpinnerItemSelection(){
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    @Override
    public boolean onDown(MotionEvent e){
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e){

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e){
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e){

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e2.getX() > e1.getX()){
            Intent swipeRight = new Intent(MainActivity.this, LiteSQLActivity.class);
            startActivity(swipeRight);
        }

        return true;
    }

    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener{

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {

            if (spinner1.getSelectedItem().equals("CHOOSE YOUR COLOR HERE (Black default)")){
                tv.setTextColor(Color.BLACK);
            }if (spinner1.getSelectedItem().equals("Blue")){
                tv.setTextColor(Color.BLUE);
            }if (spinner1.getSelectedItem().equals("Green")){
                tv.setTextColor(Color.GREEN);
            }if (spinner1.getSelectedItem().equals("Magenta")){
                tv.setTextColor(Color.MAGENTA);
            }if (spinner1.getSelectedItem().equals("Red")){
                tv.setTextColor(Color.RED);
            }if (spinner1.getSelectedItem().equals("Gray")){
                tv.setTextColor(Color.GRAY);
            }if (spinner1.getSelectedItem().equals("Cyan")){
                tv.setTextColor(Color.CYAN);
            }if (spinner1.getSelectedItem().equals("Yellow")){
                tv.setTextColor(Color.YELLOW);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0){

        }

    }

    public void onRadioButtonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.small:
                if (checked)
                    tv.setTextSize(10);
                    break;
            case R.id.normal:
                if (checked)
                    tv.setTextSize(18);
                    break;
            case R.id.medium:
                if (checked)
                    tv.setTextSize(30);
                    break;
            case R.id.big:
                if (checked)
                    tv.setTextSize(50);
                    break;
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        return true;
    }

    public void onGroupItemClick (MenuItem item){
        if (item.isChecked()) {
            item.setChecked(false);
        } else {
            item.setChecked(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return true;
    }

    //android Context Menu---
    @SuppressLint("ResourceType")
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.layout.activity_meno, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle().equals("PARANOID")){
            Typeface tfFutura = Typeface.createFromAsset(getAssets(), "Fonts/PARANOID.TTF");
            tv.setTypeface(tfFutura);
        }if (item.getTitle().equals("DroidSerif-Regular")){
            Typeface tfFutura = Typeface.createFromAsset(getAssets(), "Fonts/DroidSerif-Regular.ttf");
            tv.setTypeface(tfFutura);
        }if (item.getTitle().equals("DroidSerif-Italic")){
            Typeface tfFutura = Typeface.createFromAsset(getAssets(), "Fonts/DroidSerif-Italic.ttf");
            tv.setTypeface(tfFutura);
        }if (item.getTitle().equals("DroidSerif-Bold")){
            Typeface tfFutura = Typeface.createFromAsset(getAssets(), "Fonts/DroidSerif-Bold.ttf");
            tv.setTypeface(tfFutura);
        }if (item.getTitle().equals("DroidSerif-BoldItalic")){
            Typeface tfFutura = Typeface.createFromAsset(getAssets(), "Fonts/DroidSerif-BoldItalic.ttf");
            tv.setTypeface(tfFutura);
        }if (item.getTitle().equals("Gesture Stroke")){
            Typeface tfFutura = Typeface.createFromAsset(getAssets(), "Fonts/Gesture Stroke.ttf");
            tv.setTypeface(tfFutura);
        }if (item.getTitle().equals("Roboto-Regular")){
            Typeface tfFutura = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Regular.ttf");
            tv.setTypeface(tfFutura);
        }if (item.getTitle().equals("Roboto-Italic")){
            Typeface tfFutura = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Italic.ttf");
            tv.setTypeface(tfFutura);
        }if (item.getTitle().equals("Roboto-Bold")){
            Typeface tfFutura = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Bold.ttf");
            tv.setTypeface(tfFutura);
        }if (item.getTitle().equals("Roboto-BoldItalic")){
            Typeface tfFutura = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-BoldItalic.ttf");
            tv.setTypeface(tfFutura);
        }

        return true;
    }

    public class CustomWidget extends View {
        public CustomWidget(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);// The Canvas class holds the "draw" calls

            // Paint class holds the style and color information about how to draw
            Paint paint = new Paint(); //
            paint.setStyle(Paint.Style.FILL);

            // make the entire canvas white
            canvas.drawColor(Color.BLUE);

            // draw blue circle with antialiasing turned on
            paint.setAntiAlias(true);
            paint.setColor(Color.CYAN);
            // drawCircle(cx, cy, radius, Paint).
            canvas.drawCircle(940, 90, 45, paint);

            // draw blue circle with antialiasing turned on
            paint.setAntiAlias(true);
            paint.setColor(Color.BLUE);
            // drawCircle(cx, cy, radius, Paint).
            canvas.drawCircle(910, 100, 45, paint);

            // draw a solid green rectangle
            paint.setAntiAlias(false);
            paint.setColor(Color.RED);
            // drawRect(left, top, right, bottom, Paint
            canvas.drawRect(130, 65, 200, 200, paint);

            // draw a solid green rectangle
            paint.setAntiAlias(false);
            paint.setColor(Color.YELLOW);
            // drawRect(left, top, right, bottom, Paint
            canvas.drawRect(100, 150, 600, 550, paint);

            // draw a solid green rectangle
            paint.setAntiAlias(false);
            paint.setColor(Color.CYAN);
            // drawRect(left, top, right, bottom, Paint
            canvas.drawRect(550, 300, 430, 200, paint);

            // draw a solid green rectangle
            paint.setAntiAlias(true);
            paint.setColor(Color.CYAN);
            // drawRect(left, top, right, bottom, Paint
            canvas.drawRect(150, 300, 270, 200, paint);

            // draw a solid green rectangle
            paint.setAntiAlias(false);
            paint.setColor(Color.GRAY);
            // drawRect(left, top, right, bottom, Paint
            canvas.drawRect(200, 750, 300, 350, paint);


            // draw blue circle with antialiasing turned on
            paint.setAntiAlias(true);
            paint.setColor(Color.BLACK);
            // drawCircle(cx, cy, radius, Paint).
            canvas.drawCircle(280, 450, 10, paint);
        }
    }

}
