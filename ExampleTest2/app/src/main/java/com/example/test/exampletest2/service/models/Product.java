package com.example.test.exampletest2.service.models;

public class Product {
    String name;
    String content;
    int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Product() {
    }

    public Product(String name, String content, int value) {
        this.name = name;
        this.content = content;
        this.value = value;
    }
}
