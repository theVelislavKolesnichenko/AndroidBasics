package com.github.thevelislavkolesnichenko.arrayadapterexample;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.github.thevelislavkolesnichenko.arrayadapterexample.Data.Repository;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] estimates = Repository.getItemsList();

        ArrayAdapter<String> estimatesAdapter = new ArrayAdapter<String>(
                this,
                        R.layout.item,
                        R.id.textView,
                        estimates
                );

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(estimatesAdapter);
    }
}
