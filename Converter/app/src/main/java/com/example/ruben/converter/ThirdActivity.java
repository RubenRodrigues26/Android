package com.example.ruben.converter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by marinatalaya on 06/11/2017.
 */

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle firstData = getIntent().getExtras();
        if (firstData == null) {
            return;
        }
        String firstMessage = firstData.getString("firstMessage");
        TextView first = (TextView) findViewById(R.id.idThird);
        first.setText(firstMessage);

        firstClickListener();
    }

    public void firstClickListener(){
        TextView third = (TextView) findViewById(R.id.btnSendFirst) ;
        third.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent thirdIntend = new Intent(ThirdActivity.this, MainActivity.class);
                        // get user input
                        final EditText userInput = (EditText) findViewById(R.id.passdataInput31);
                        String userMessage = userInput.getText().toString();
                        // pass user input in the intent
                        thirdIntend.putExtra("firstMessage", userMessage);

                        startActivity(thirdIntend);
                    }
                }
        );
    }
}
