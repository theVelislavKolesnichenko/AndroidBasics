package com.github.thevelislavkolesnichenko.asynctaskexample;


import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoaderFragment extends DialogFragment {

    private TextView textView;

    public LoaderFragment() {
        // Required empty public constructor
    }

    public static LoaderFragment newInstance(int time) {
        LoaderFragment customFragment = new LoaderFragment();
        Bundle args = new Bundle();
        args.putInt("user_name", time);
        customFragment.setArguments(args);
        return customFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loader, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.textView2);
        //String value = getArguments().getString("key", "Wait");
        //textView.setText(value);
    }

    public void UpdateValue(int value) {
        textView.setText("Wait for " + value + " seconds");
    }
}
