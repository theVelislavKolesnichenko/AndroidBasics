package bg.tu_varna.sit.recyclerviewexample.date;

import bg.tu_varna.sit.recyclerviewexample.models.Fruit;
import bg.tu_varna.sit.recyclerviewexample.models.Vegetables;

import java.util.ArrayList;
import java.util.Random;

public class Storage {
    public static ArrayList<Vegetables> generate(int count) {
        ArrayList<Vegetables> vegetables = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= count; i++) {
            vegetables.add(
                    new Vegetables("Vegetables" + i, 0.8*i, random.nextInt(255)+1));
            vegetables.add(
                    new Fruit("Fruit" + i, 0.8*i, 9*i, random.nextInt(255)+1));
        }

        return vegetables;
    }
}
