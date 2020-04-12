package com.github.thevelislavkolesnichenko.recyclerviewexample;

import android.view.View;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.recyclerviewexample.adapter.ContactAdapter;
import com.github.thevelislavkolesnichenko.recyclerviewexample.data.ContactSource;
import com.github.thevelislavkolesnichenko.recyclerviewexample.search.CustomFilter;
import com.github.thevelislavkolesnichenko.recyclerviewexample.search.CustomSearch;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rv);
        ContactAdapter adapter = new ContactAdapter(ContactSource.generateContactList(10));
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        floatingActionButton = findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new CustomSearch(new CustomFilter(adapter)));
    }
}
