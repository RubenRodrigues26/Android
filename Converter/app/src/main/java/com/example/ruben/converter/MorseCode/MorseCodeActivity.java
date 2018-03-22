package com.example.ruben.converter.MorseCode;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruben.converter.R;

/**
 * Created by rubenrodrigues on 05/11/2017.
 */

public class MorseCodeActivity extends AppCompatActivity {

    private TextView txt;
    private TextView result;
    String nova;
    int no;
    private Button toMorseBtn;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morsecode);

        txt = (TextView) findViewById(R.id.txt);
        result = (TextView) findViewById(R.id.result);
        toMorseBtn = (Button) findViewById(R.id.toMorseBtn);

        toMorseBtn.setOnClickListener((view) -> {
            String txtToConvert = txt.getText().toString();
            String convertedTxt = MorseCodeFunctionality.alphaToMorseCode(txtToConvert);
            result.setText(convertedTxt);
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        nova = txt.getText().toString();

        outState.putString("text", nova);
        outState.putInt("no", no);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        txt.setText(savedInstanceState.getString("text"));
        no = savedInstanceState.getInt("no");
    }
}

