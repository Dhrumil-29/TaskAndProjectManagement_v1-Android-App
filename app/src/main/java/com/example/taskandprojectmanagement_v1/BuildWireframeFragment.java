package com.example.taskandprojectmanagement_v1;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BuildWireframeFragment extends Fragment {

    Dialog dialog;
    RadioButton radioButton;
    RadioGroup radioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_build_wireframe, container, false);
        BottomAppBar bottomAppBar = requireActivity().findViewById(R.id.bottomAppBar);
        bottomAppBar.setVisibility(View.GONE);

        FloatingActionButton floatingActionButton = requireActivity().findViewById(R.id.floatingActionButton);
        floatingActionButton.setVisibility(View.GONE);

        TextView status = view.findViewById(R.id.status);
        status.setOnClickListener(v -> status());

        TextView dueDate = view.findViewById(R.id.dueDate);
        dueDate.setOnClickListener(v -> dueDate());
        TextView addAttachment = view.findViewById(R.id.addAttachment);
        addAttachment.setOnClickListener(v -> addAttachment());

        TextView backFromBuildWireframe = view.findViewById(R.id.backFromBuildWireframe);
        backFromBuildWireframe.setOnClickListener(v -> backFromBuildWireframe());
        return view;
    }

    private void status() {
        showDialog();
    }

    private void backFromBuildWireframe() {
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        replaceFragment(fragmentTransaction, new ProjectDetailFragment());
    }

    private void replaceFragment(FragmentTransaction fragmentTransaction, Fragment replaceFragmentName) {
        fragmentTransaction.replace(R.id.frame_layout, replaceFragmentName).addToBackStack("");
        fragmentTransaction.commit();
    }

    private void dueDate() {
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.due_date_dialog);
        dialog.show();

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void addAttachment() {
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.attachment_dialog);
        dialog.show();

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void showDialog() {
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.status_dialog);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}