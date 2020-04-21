package com.github.thevelislavkolesnichenko.runnobleexample.models;

public class User {
    private String email;
    private String password;

    public User(String email, String name) {
        this.email = email;
        this.password = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
