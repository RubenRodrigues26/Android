package com.example.ruben.converter.LiteSQL;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruben.converter.LiteSQL.Comment;
import com.example.ruben.converter.LiteSQL.dbHandler;
import com.example.ruben.converter.MainActivity;
import com.example.ruben.converter.R;
import com.example.ruben.converter.ThirdActivity;

/**
 * Created by rubenrodrigues on 05/11/2017.
 */

public class LiteSQLActivity extends AppCompatActivity {

    EditText user_Input;
    TextView valuesTextView;
    com.example.ruben.converter.LiteSQL.dbHandler dbHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litesql);

        user_Input = (EditText) findViewById(R.id.user_Input);
        valuesTextView = (TextView) findViewById(R.id.records_TextView);

        dbHandler = new dbHandler(this, null, null, 1);
        printDatabase();

        addButtonClicked();
    }
    public void printDatabase(){
        String dbValues = dbHandler.databaseToString();
        valuesTextView.setText(dbValues);
        user_Input.setText("");
    }

    public void addButtonClicked(){
        TextView addComment = (TextView) findViewById(R.id.add_Btnsql) ;
        addComment.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Comment comment = new Comment(user_Input.getText().toString());
                        dbHandler.addComment(comment);
                        printDatabase();

                    }
                }
        );
    }
}
