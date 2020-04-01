package com.github.thevelislavkolesnichenko.fragmentapplication.models;

public class Animal {
    private String name;
    private String type;
    private String imageUrl;

    public Animal(String name, String type, String imageUrl) {
        this.name = name;
        this.type = type;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

