package com.github.thevelislavkolesnichenko.fragmentapplication.data;

import com.github.thevelislavkolesnichenko.fragmentapplication.models.Animal;

import java.util.ArrayList;

public class AnimalSource {

    ArrayList<Animal> animals;

    public AnimalSource() {
        animals = new ArrayList<Animal>() {{
            add(new Animal("Charly", "Dog", "url/dog"));
            add(new Animal("Sara", "Cat", "url/cat"));
        }};
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
