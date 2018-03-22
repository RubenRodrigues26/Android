package com.example.ruben.converter;

/**
 * Created by marinatalaya on 06/11/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle firstData = getIntent().getExtras();
        if (firstData == null) {
            return;
        }
        String firstMessage = firstData.getString("firstMessage");
        TextView first = (TextView) findViewById(R.id.idSecond);
        first.setText(firstMessage);

        thirdonClickListener();
    }


    public void thirdonClickListener(){
        TextView third = (TextView) findViewById(R.id.btnThird) ;
        third.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent thirdIntend = new Intent(SecondActivity.this, ThirdActivity.class);
                        // get user input
                        final EditText userInput = (EditText) findViewById(R.id.passdataInput23);
                        String userMessage = userInput.getText().toString();
                        // pass user input in the intent
                        thirdIntend.putExtra("firstMessage", userMessage);

                        startActivity(thirdIntend);
                    }
                }
        );
    }
}