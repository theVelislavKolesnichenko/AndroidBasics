package com.github.thevelislavkolesnichenko.fragmentapplication.data;

import com.github.thevelislavkolesnichenko.fragmentapplication.models.Animal;

import java.util.ArrayList;

public class AnimalSource {

    ArrayList<Animal> animals;

    public AnimalSource() {
        animals = new ArrayList<Animal>() {{
            add(new Animal("Charly", "Dog", "https://www.brandeps.com/icon-download/D/Dog-icon-vector-01.svg"));
            add(new Animal("Sara", "Cat", "https://www.brandeps.com/icon-download/C/Cat-icon-vector-01.svg"));
        }};
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
