package com.example.adhdone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    Context context;
    ArrayList<Task> tasks;

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the layout (giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_tasks_row, parent, false);
        return new TaskAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        // Assigning values to the views we created in the task_row layout file
        // based on the position of the recycler view

        holder.taskDescription.setText(tasks.get(position).getDescription());
        //holder.taskIcon.setImageResource(tasks.get(position).getIconId());
    }

    @Override
    public int getItemCount() {
        // The recycler view just wants to know the number of items you want displayed
        return tasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Grabbing the views from our task_row layout file
        // Kinda like in the onCreate method

        ImageView taskIcon;
        TextView taskDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            taskIcon = itemView.findViewById(R.id.taskIcon);
            taskDescription = itemView.findViewById(R.id.taskDescription);
        }
    }
}
