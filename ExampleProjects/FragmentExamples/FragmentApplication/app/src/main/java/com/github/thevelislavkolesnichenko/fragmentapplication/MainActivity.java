package com.github.thevelislavkolesnichenko.fragmentapplication;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.fragmentapplication.adapters.AnimalAdapter;
import com.github.thevelislavkolesnichenko.fragmentapplication.data.AnimalSource;
import com.github.thevelislavkolesnichenko.fragmentapplication.listener.AddAnimalDialogListener;
import com.github.thevelislavkolesnichenko.fragmentapplication.models.Animal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AddAnimalDialogListener {

    RecyclerView recyclerView;
    AnimalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        AnimalSource animals = new AnimalSource();

        adapter = new AnimalAdapter(animals.getAnimals());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                AddAnimalFragment addAnimalFragment = AddAnimalFragment.newInstance();
                addAnimalFragment.show(fm, "fragment_add_animal");
            }
        });
    }

    @Override
    public void onFinishAddDialog(Animal animal) {
        adapter.addAnimal(animal);
    }
}
