package com.example.adhdone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    CoordinatorLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.coordinatorLayout);

        // Manage the selection of the bottom navigation options
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.task) {
                    replaceFragment(new TaskFragment());
                    return true;
                }
                if (id == R.id.calendar) {
                    replaceFragment(new CalendarFragment());
                    return true;
                }
                if (id == R.id.stats) {
                    replaceFragment(new StatsFragment());
                    return true;
                }
                if (id == R.id.options) {
                    replaceFragment(new OptionsFragment());
                    return true;
                }
                return true;
            }
        });

        // Managing the FAB listener
        FloatingActionButton fab = findViewById(R.id.fabNewTask);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // replaceFragment(new NewTaskPopUp());
                createPopUp();
            }
        });
    }
private  void createPopUp() {
    LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    View popupView = inflater.inflate(R.layout.popup_new_task, null);

    int width = ViewGroup.LayoutParams.MATCH_PARENT;
    int height = ViewGroup.LayoutParams.WRAP_CONTENT;
    boolean focusable = false;
    PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
    layout.post(new Runnable() {
        @Override
        public void run() {
            popupWindow.showAtLocation(layout, Gravity.BOTTOM,0,0);
        }
    });
}

    private  void replaceFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment);
        transaction.commit();
    }
}