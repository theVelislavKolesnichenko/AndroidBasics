package com.github.thevelislavkolesnichenko.customarrayadapter.models;

public class User {
    private String name;
    private City city;

    public User(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }
}
