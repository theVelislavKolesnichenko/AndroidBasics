package bg.tu_varna.sit.zooapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

import bg.tu_varna.sit.zooapplication.adapters.CageAdapter;
import bg.tu_varna.sit.zooapplication.listeners.OnAddAnimalListener;
import bg.tu_varna.sit.zooapplication.listeners.OnAddCageListener;
import bg.tu_varna.sit.zooapplication.models.Cage;
import bg.tu_varna.sit.zooapplication.views.AddAnimalFragment;
import bg.tu_varna.sit.zooapplication.views.AddCageFragment;

public class MainActivity extends AppCompatActivity implements OnAddCageListener, OnAddAnimalListener {

    private RecyclerView recyclerView;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new CageAdapter(new ArrayList<Cage>(), this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button = findViewById(R.id.button);
        button.setOnClickListener(r -> {
            AddCageFragment fragment = AddCageFragment.newInstance(this);
            fragment.show(getSupportFragmentManager(), "cage");
        });
    }

    @Override
    public void OnAddCage(Cage cage) {
        CageAdapter adapter = (CageAdapter) recyclerView.getAdapter();
        adapter.addCage(cage);
    }

    @Override
    public void onAddAnimal(Cage cage) {
        AddAnimalFragment fragment = AddAnimalFragment.newInstance(cage, this);
        fragment.show(getSupportFragmentManager(), "animal");

    }

    @Override
    public void onUpdate() {
        CageAdapter adapter = (CageAdapter) recyclerView.getAdapter();
        adapter.notifyDataSetChanged();
    }
}