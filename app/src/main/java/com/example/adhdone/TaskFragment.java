package com.example.adhdone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TaskFragment extends Fragment {

    // Add RecyclerView member
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, parent, false);

        // Create RecyclerView
        recyclerView = view.findViewById(R.id.recyclerTasks);
        TaskAdapter adapter = new TaskAdapter(view.getContext(),createTaskList(20));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

    public static ArrayList<Task> createTaskList(int numTasks) {
        int lastTaskId = 0;

        ArrayList<Task> tasks = new ArrayList<>();

        for (int i = 1; i <= numTasks; i++) {
            tasks.add(new Task(++lastTaskId,1, "Task" + lastTaskId," "," ", " ", " ",true,100));
        }

        return tasks;
    }
}