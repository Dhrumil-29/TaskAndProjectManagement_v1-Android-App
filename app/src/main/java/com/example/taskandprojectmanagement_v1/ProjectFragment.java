package com.example.taskandprojectmanagement_v1;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProjectFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_project, container, false);
        BottomAppBar bottomAppBar = requireActivity().findViewById(R.id.bottomAppBar);
        bottomAppBar.setVisibility(View.VISIBLE);

        FloatingActionButton floatingActionButton = requireActivity().findViewById(R.id.floatingActionButton);
        floatingActionButton.setVisibility(View.VISIBLE);

        CardView project1 = view.findViewById(R.id.project1);
        project1.setOnClickListener(v -> project1());

        return view;
    }

    private void replaceFragment(FragmentTransaction fragmentTransaction, Fragment replaceFragmentName) {
        fragmentTransaction.replace(R.id.frame_layout, replaceFragmentName).addToBackStack("");
        fragmentTransaction.commit();
    }
    public void project1() {
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        replaceFragment(fragmentTransaction, new ProjectDetailFragment());
    }

}