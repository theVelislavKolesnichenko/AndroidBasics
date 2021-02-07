package com.github.thevelislavkolesnichenko.hairdresser.data;

import com.github.thevelislavkolesnichenko.hairdresser.model.Customer;

import java.util.ArrayList;

public class Source {

    public static ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            customers.add(new Customer("cat name " + i, "cat type " + i, false));
        }

        return customers;
    }
}
