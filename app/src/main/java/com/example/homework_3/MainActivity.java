package com.example.homework_3;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
    implements onTaskClickListener {
    Button button;
    TextView textView;
    MyAdapter adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new MyAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    public void onClick(View v){
        if (v == button){
            Intent intent = new Intent(this, SecondActivity.class);
            startActivityForResult(intent,22);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 22){
            if (resultCode == RESULT_OK){
                Task task= (Task) data.getSerializableExtra(SecondActivity.RESULT_KEY);
                Log.d("ololo", task.title+" " +task.description);
                adapter.data.add(task);
                adapter.notifyDataSetChanged();

            }
        }
    }

    @Override
    public void onTaskClick(Task task) {
        Intent intent = new Intent(MainActivity.this, TaskDetailsActivity.class);
        intent.putExtra("key", task);
        startActivity(intent);

    }
}