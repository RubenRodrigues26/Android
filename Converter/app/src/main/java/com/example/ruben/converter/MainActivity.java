package com.example.ruben.converter;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruben.converter.ASCII.ASCIIActivity;
import com.example.ruben.converter.LiteSQL.LiteSQLActivity;
import com.example.ruben.converter.MorseCode.MorseCodeActivity;
import com.example.ruben.converter.RPhonetics.RPhoneticsActivity;
import com.example.ruben.converter.TextSpeak.TextSpeakActivity;

public class MainActivity extends AppCompatActivity {

    //Building the object notification
    NotificationCompat.Builder notification;
    //Giving an ID to the notifications (each notification can only have one id)
    private static final int noID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiating the notification object builder
        notification = new NotificationCompat.Builder(this);
        //Delete nofitication after clicking on it
        notification.setAutoCancel(true);

        //Caaling methods
        asciionClickListener();
        rphoneticsonClickListener();
        morsecodeonClickListener();
        textspeakonClickListener();
        litesqlonClickListener();
        secondonClickListener();
        thirdonClickListener();

        //Store information in firstData and validate that is has a value
        Bundle firstData = getIntent().getExtras();
        if (firstData == null) {
            return;
        }
        //Stores the inforamtion passe into firstData
        String firstMessage = firstData.getString("firstMessage");
        // Find the View
        TextView first = (TextView) findViewById(R.id.passdata);
        //Change text to what the user passed in into firstMessage
        first.setText(firstMessage);

    }

    // Set a click listener on that View
    public void asciionClickListener(){
        // Find the View
        TextView ascii = (TextView) findViewById(R.id.ascii);
        ascii.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent asciiIntent = new Intent(MainActivity.this, ASCIIActivity.class);
                        startActivity(asciiIntent);
                    }
                }
        );
    }

    // Set a click listener on that View
    public void rphoneticsonClickListener(){
        // Find the View
        TextView radio = (TextView) findViewById(R.id.rphonetics);
        radio.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent radioIntent = new Intent(MainActivity.this, RPhoneticsActivity.class);
                        startActivity(radioIntent);
                        //setting notifications values
                        notification.setSmallIcon(R.drawable.ic_stat_name);
                        notification.setTicker("Im the ticker!");
                        notification.setWhen(System.currentTimeMillis());
                        notification.setContentTitle("Morse Code");
                        notification.setContentText("Call 021 0000001");

                        Intent msgIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:021 0000001"));
                        PendingIntent intent = PendingIntent.getActivity(MainActivity.this, 0, msgIntent, Intent.FLAG_ACTIVITY_NEW_TASK);
                        notification.setContentIntent(intent);

                        //Builds notification and issues it
                        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        nm.notify(noID, notification.build());
                    }
                }
        );
    }
    // Set a click listener on that View
    public void morsecodeonClickListener(){
        // Find the View
        TextView morse = (TextView) findViewById(R.id.morsecode);
        morse.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent morseIntent = new Intent(MainActivity.this, MorseCodeActivity.class);
                        startActivity(morseIntent);
                    }
                }
        );
    }
    // Set a click listener on that View
    public void textspeakonClickListener(){
        // Find the View
        TextView textspeak = (TextView) findViewById(R.id.textspeak);
        textspeak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent textspeakIntent = new Intent(MainActivity.this, TextSpeakActivity.class);
                        startActivity(textspeakIntent);
                    }
                }
        );
    }
    // Set a click listener on that View
    public void litesqlonClickListener(){
        // Find the View
        TextView litesql = (TextView) findViewById(R.id.qlitesql);
        litesql.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent litesqlIntent = new Intent(MainActivity.this, LiteSQLActivity.class);
                        startActivity(litesqlIntent);
                    }
                }
        );
    }
    // Set a click listener on that View
    public void secondonClickListener(){
        // Find the View
        TextView second = (TextView) findViewById(R.id.btnFirst) ;
        second.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent secondIntend = new Intent(MainActivity.this, SecondActivity.class);
                        // get user input
                        final EditText userInput = (EditText) findViewById(R.id.passdataInput12);
                        String userMessage = userInput.getText().toString();
                        // pass user input in the intent
                        secondIntend.putExtra("firstMessage", userMessage);

                        startActivity(secondIntend);
                    }
                }
        );
    }
    // Set a click listener on that View
    public void thirdonClickListener(){
        // Find the View
        TextView third = (TextView) findViewById(R.id.btnThird) ;
        third.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent thirdIntend = new Intent(MainActivity.this, ThirdActivity.class);
                        // get user input
                        final EditText userInput = (EditText) findViewById(R.id.passdataInput12);
                        String userMessage = userInput.getText().toString();
                        // pass user input in the intent
                        thirdIntend.putExtra("firstMessage", userMessage);

                        startActivity(thirdIntend);
                    }
                }
        );
    }
}
