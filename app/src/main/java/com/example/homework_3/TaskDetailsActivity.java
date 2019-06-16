package com.example.homework_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TaskDetailsActivity extends AppCompatActivity {

    TextView title;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        title = findViewById(R.id.title3);
        description = findViewById(R.id.desc3);

        Intent intent= getIntent();
        Task task=(Task) intent.getSerializableExtra("key");
        title.setText(task.title);
        description.setText(task.description);
    }
}
