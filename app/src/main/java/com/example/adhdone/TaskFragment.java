package com.example.adhdone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Random;

public class TaskFragment extends Fragment {

    // Add RecyclerView member
    private RecyclerView recyclerView;

    // TODO: add list dynamic tabview so tabs can be added and deleted by user
    // See: https://proandroiddev.com/synchronize-recyclerview-with-tablayout-3c5da4f3b18b
    private TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        ArrayList<Task> tasks = createTaskList(10);
        ArrayList<Tab> tabs = createTabs(4);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, parent, false);

        // TODO: Currently creating 4 random tabs. Need to load list of tabs from a file which contains their name
        // Create TabView, remove any existing tabs and re-add tabs that have been saved
        tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.removeAllTabs();
        tabs.forEach((n) -> tabLayout.addTab(tabLayout.newTab().setText(n.getTabName())));

        // Create RecyclerView
        recyclerView = view.findViewById(R.id.recyclerTasks);
        TaskAdapter adapter = new TaskAdapter(view.getContext(),tasks);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

    public static ArrayList<Task> createTaskList(int numTasks) {
        int lastTaskId = 0;
        Random random = new Random();

        ArrayList<Task> tasks = new ArrayList<>();

        for (int i = 1; i <= numTasks; i++) {
            int n = random.nextInt(3);
            tasks.add(new Task(++lastTaskId,1,n, "Task" + lastTaskId," "," ", " ", " ",true,100));
        }

        return tasks;
    }

    public static ArrayList<Tab> createTabs(int numTabs) {
        ArrayList<Tab> tabs = new ArrayList<>();

        for (int i = 1; i <= numTabs; i++) {
            tabs.add(new Tab(i,Integer.toString(i),i));
        }

        return tabs;
    }
}