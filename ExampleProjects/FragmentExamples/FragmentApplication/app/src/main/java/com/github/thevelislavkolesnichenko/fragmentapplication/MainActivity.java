package com.github.thevelislavkolesnichenko.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.fragmentapplication.adapters.AnimalAdapter;
import com.github.thevelislavkolesnichenko.fragmentapplication.data.AnimalSource;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        AnimalAdapter adapter = new AnimalAdapter(AnimalSource.getAnimals());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
