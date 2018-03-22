package com.example.ruben.converter.RPhonetics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruben.converter.R;

/**
 * Created by rubenrodrigues on 05/11/2017.
 */

public class RPhoneticsActivity extends AppCompatActivity{

    private TextView txt;
    private TextView result;
    private Button toRPhoneticsBtn;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiophonetics);

        txt = (TextView) findViewById(R.id.txt);
        result = (TextView) findViewById(R.id.result);
        toRPhoneticsBtn = (Button) findViewById(R.id.toRPhoneticsBtn);

        toRPhoneticsBtn.setOnClickListener((view) -> {
            String txtToConvert = txt.getText().toString();
            String convertedTxt = RPhoneticsFunctionality.alphaToRphonetics(txtToConvert);
            result.setText(convertedTxt);
        });
    }

}
