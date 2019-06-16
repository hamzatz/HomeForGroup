package com.example.homework_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    public static String RESULT_KEY = "resultKey";

    EditText titleEditText;
    Button save;
    Button cancel;
    EditText decriptionEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        titleEditText= findViewById(R.id.title_edit_text);
        decriptionEditText= findViewById(R.id.description_edit_text);
        save= findViewById(R.id.save);
        cancel=findViewById(R.id.cancel);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                String title =titleEditText.getText().toString();
                String description =decriptionEditText.getText().toString();
                Task task= new Task(title,description);
                intent.putExtra(RESULT_KEY,task);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


    }
}
