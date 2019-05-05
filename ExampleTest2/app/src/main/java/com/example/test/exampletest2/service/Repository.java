package com.example.test.exampletest2.service;

import com.example.test.exampletest2.R;
import com.example.test.exampletest2.service.models.Product;

import java.util.ArrayList;

public class Repository extends ArrayList<Product> {

    //List<Product> persons = new ArrayList<>();

    public Repository() {
        initializeData();
    }

    private void initializeData() {

        this.add(new Product("Emma Wilson", "23 years old", R.drawable.ic_launcher_background));
        this.add(new Product("Lavery Maiss", "25 years old", R.drawable.ic_launcher_background));
        this.add(new Product("Lillie Watts", "35 years old", R.drawable.ic_launcher_background));
    }
}
