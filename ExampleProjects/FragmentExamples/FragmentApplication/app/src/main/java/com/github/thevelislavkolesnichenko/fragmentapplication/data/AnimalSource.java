package com.github.thevelislavkolesnichenko.fragmentapplication.data;

import com.github.thevelislavkolesnichenko.fragmentapplication.models.Animal;

import java.util.ArrayList;

public class AnimalSource {
    public static ArrayList<Animal> getAnimals() {
        return new ArrayList<Animal>() {{
            add(new Animal("Charly", "Dog", "url/dog"));
            add(new Animal("Sara", "Cat", "url/cat"));
        }};
    }
}
