package com.example.taskandprojectmanagement_v1;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        BottomAppBar bottomAppBar = requireActivity().findViewById(R.id.bottomAppBar);
        bottomAppBar.setVisibility(View.VISIBLE);
        FloatingActionButton floatingActionButton = requireActivity().findViewById(R.id.floatingActionButton);
        floatingActionButton.setVisibility(View.VISIBLE);
        TextView RecentProjectSeeAll = view.findViewById(R.id.RecentProjectSeeAll);
        TextView TodayTaskSeeAll = view.findViewById(R.id.TodayTaskSeeAll);
        CardView project1 = view.findViewById(R.id.project1);
        project1.setOnClickListener(v -> project1());
        RecentProjectSeeAll.setOnClickListener(v -> RecentProjectSeeAll());
        TodayTaskSeeAll.setOnClickListener(v -> TodayTaskSeeAll());

        return view;
    }


    public void RecentProjectSeeAll() {
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        replaceFragment(fragmentTransaction, new AllRecentProjectsFragment());
    }

    private void replaceFragment(FragmentTransaction fragmentTransaction, Fragment replaceFragmentName) {
        fragmentTransaction.replace(R.id.frame_layout, replaceFragmentName).addToBackStack("");
        fragmentTransaction.commit();
    }

    public void TodayTaskSeeAll() {
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        replaceFragment(fragmentTransaction, new AllTodayTasksFragment());
    }

    public void project1() {
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        replaceFragment(fragmentTransaction, new ProjectDetailFragment());
    }
}