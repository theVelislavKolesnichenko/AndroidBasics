package com.github.thevelislavkolesnichenko.recyclerviewexample.data;

import com.github.thevelislavkolesnichenko.recyclerviewexample.model.Contact;

import java.util.ArrayList;
import java.util.Random;

public class ContactSource {
    public static ArrayList<Contact> generateContactList(int count) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        Random random = new Random();

        for (int i = 1; i <= count; i++) {
            contacts.add(new Contact("Person " + i, 1000000000L + random.nextLong() % 9999999999L ));
        }

        return contacts;
    }
}
