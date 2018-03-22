package com.example.ruben.converter.TextSpeak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruben.converter.R;
import com.example.ruben.converter.RPhonetics.RPhoneticsFunctionality;

/**
 * Created by marinatalaya on 05/11/2017.
 */

public class TextSpeakActivity extends AppCompatActivity {

    private TextView txt;
    private TextView result;
    private Button toTextSpeakBtn;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textspeak);

        txt = (TextView) findViewById(R.id.txt);
        result = (TextView) findViewById(R.id.result);
        toTextSpeakBtn = (Button) findViewById(R.id.toTextSpeakBtn);

        toTextSpeakBtn.setOnClickListener((view) -> {
            String txtToConvert = txt.getText().toString();
            String convertedTxt = TextSpeakFunctionality.alphaToTextspeak(txtToConvert);
            result.setText(convertedTxt);
        });
    }
}
