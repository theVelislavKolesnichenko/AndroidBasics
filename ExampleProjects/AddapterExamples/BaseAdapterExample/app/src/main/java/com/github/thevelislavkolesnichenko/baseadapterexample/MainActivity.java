package com.github.thevelislavkolesnichenko.baseadapterexample;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.github.thevelislavkolesnichenko.baseadapterexample.adapters.CityAdapter;
import com.github.thevelislavkolesnichenko.baseadapterexample.data.CitySource;
import com.github.thevelislavkolesnichenko.baseadapterexample.models.City;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // създаване на списък с данни
        ArrayList<City> cities = CitySource.generateItemsList(); // функция за получawane списък с елементи

        //Създаване на адаптер за персонален списък
        CityAdapter adapter =  new  CityAdapter(this, cities);

        // извличане ListView
        ListView itemsListView = findViewById(R.id.listView);
        // задаване на адаптер
        itemsListView.setAdapter(adapter);
    }
}
