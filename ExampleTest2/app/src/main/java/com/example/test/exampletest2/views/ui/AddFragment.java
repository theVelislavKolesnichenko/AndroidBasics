package com.example.test.exampletest2.views.ui;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import com.example.test.exampletest2.R;
import com.example.test.exampletest2.databinding.FragmentAddBinding;
import com.example.test.exampletest2.service.Repository;
import com.example.test.exampletest2.viewmodels.EditProductViewModel;
import com.example.test.exampletest2.viewmodels.ProductListViewModel;

public class AddFragment extends DialogFragment implements View.OnClickListener {

    private EditProductViewModel editProductViewModel;
    private ProductListViewModel productListViewModel;

    public AddFragment() {

    }

    public static AddFragment newInstance(ProductListViewModel productListViewModel) {
        AddFragment frag = new AddFragment();
        frag.productListViewModel = productListViewModel;
        return  frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FragmentAddBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container,false);
        editProductViewModel = ViewModelProviders.of(this).get(EditProductViewModel.class);
        binding.setEditProduct(editProductViewModel);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set focus to first edit text
        ((EditText)view.findViewById(R.id.editText)).requestFocus();
        // Set on click listener to add button
        ((Button)view.findViewById(R.id.button)).setOnClickListener(this);

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onClick(View v) {
        productListViewModel.addProduct(editProductViewModel.getProduct());
        dismiss();
    }
}
