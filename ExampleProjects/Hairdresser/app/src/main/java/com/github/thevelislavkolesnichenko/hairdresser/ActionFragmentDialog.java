package com.github.thevelislavkolesnichenko.hairdresser;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.thevelislavkolesnichenko.hairdresser.listener.OnFragmentInteractionListener;
import com.github.thevelislavkolesnichenko.hairdresser.model.Customer;


public class ActionFragmentDialog extends DialogFragment {
    private OnFragmentInteractionListener mListener;
    private TextView name, type;
    private Button back, start;

    public ActionFragmentDialog() {
    }

    public static ActionFragmentDialog newInstance(Customer customer, int position) {
        ActionFragmentDialog fragment = new ActionFragmentDialog();
        Bundle args = new Bundle();
        args.putParcelable("customer", customer);
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_action_fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Customer customer = getArguments().getParcelable("customer");
        final int position =  getArguments().getInt("position");

        name = view.findViewById(R.id.textView4);
        type = view.findViewById(R.id.textView5);
        back = view.findViewById(R.id.button2);
        start = view.findViewById(R.id.button3);

        name.setText(customer.getName());
        type.setText(customer.getType());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction(position);
                dismiss();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
