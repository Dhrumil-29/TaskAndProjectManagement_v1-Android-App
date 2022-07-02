package com.example.taskandprojectmanagement_v1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AllTodayTasksFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_recent_projects, container, false);

        BottomAppBar bottomAppBar = requireActivity().findViewById(R.id.bottomAppBar);
        bottomAppBar.setVisibility(View.GONE);

        FloatingActionButton floatingActionButton = requireActivity().findViewById(R.id.floatingActionButton);
        floatingActionButton.setVisibility(View.GONE);
        TextView backFromTodayTask = view.findViewById(R.id.backFromTodayTask);
        backFromTodayTask.setOnClickListener(v -> backFromTodayTask());
        return view;

    }

    public void backFromTodayTask() {
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        replaceFragment(fragmentTransaction, new HomeFragment());
    }

    private void replaceFragment(FragmentTransaction fragmentTransaction, Fragment replaceFragmentName) {
        fragmentTransaction.replace(R.id.frame_layout, replaceFragmentName).addToBackStack("");
        fragmentTransaction.commit();
    }
}