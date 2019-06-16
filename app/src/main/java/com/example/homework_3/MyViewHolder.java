package com.example.homework_3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private onTaskClickListener listener;


    TextView textView;
    TextView textView2;
    Task task;

    public MyViewHolder(@NonNull View itemView, onTaskClickListener clickListener) {
        super(itemView);
        textView = itemView.findViewById(R.id.view_holder_text_view);
        textView2= itemView.findViewById(R.id.view_holder_text_view2);
        listener = clickListener;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTaskClick(task);


//                Intent intent = new Intent(activity,TaskDetailsActivity.class);
//                intent.putExtra("text_key",task);
//                activity.startActivity(intent);
            }
        });

        }




//    public void setActivity (onTaskClickListener listener){
//        this.listener= listener;
//
//        }
    public void onBind(Task task){
        this.task=task;
        textView.setText(task.title);
        textView2.setText(task.description);

    }

}
