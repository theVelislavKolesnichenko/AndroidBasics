package com.example.test.exampletest2.views.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.test.exampletest2.R;
import com.example.test.exampletest2.service.Repository;
import com.example.test.exampletest2.service.models.Product;
import com.example.test.exampletest2.viewmodels.ProductListViewModel;
import com.example.test.exampletest2.views.adapter.ProductAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fab;
    Repository repository;
    ProductListViewModel productListViewModel;
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);

        final RecyclerView rv = (RecyclerView)findViewById(R.id.rv);

        repository = new Repository();
        productListViewModel = new ProductListViewModel(repository);

        adapter = new ProductAdapter(productListViewModel);
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);

        productListViewModel.getProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        AddFragment editNameDialogFragment = AddFragment.newInstance(productListViewModel);
        editNameDialogFragment.show(fm, "fragment_edit_name");
    }

    @Override
    public void onClick(View v) {
        showEditDialog();
    }
}
