package com.github.thevelislavkolesnichenko.customarrayadapter.data;

import com.github.thevelislavkolesnichenko.customarrayadapter.models.City;
import com.github.thevelislavkolesnichenko.customarrayadapter.models.User;

import java.util.ArrayList;

public class UserSource {
    public static ArrayList<User> generateItemsList() {
        ArrayList<User> cites = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            cites.add(new User("User " + i,  new City("City " + i, 9000 + i)));
        }
        return  cites;
    }
}
