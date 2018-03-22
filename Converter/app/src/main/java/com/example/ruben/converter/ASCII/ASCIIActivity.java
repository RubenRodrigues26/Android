package com.example.ruben.converter.ASCII;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruben.converter.R;

/**
 * Created by rubenrodrigues on 05/11/2017.
 */

public class ASCIIActivity extends AppCompatActivity {

    private TextView txt;
    private TextView result;
    private Button toASCIIBtn;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ascii);

        /* Throw up an Alert Dialog with 3 options for ASCII" */
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setMessage("Know what ASCII is?");
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Yes its easy.",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        start_level();
                    }
                });

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "No, I'll go back and learn.",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Nevermind not intressed.",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        dialog.show();

        txt = (TextView) findViewById(R.id.txt);
        result = (TextView) findViewById(R.id.result);
        toASCIIBtn = (Button) findViewById(R.id.toHexBtn);

        toASCIIBtn.setOnClickListener((view) -> {
            String txtToConvert = txt.getText().toString();
            String convertedTxt = ASCIIFunctionality.alphaToHex(txtToConvert);
            result.setText(convertedTxt);
        });
    }
    private void start_level() {

    }
}
