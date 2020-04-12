package com.github.thevelislavkolesnichenko.asynctaskproject;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button first, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = findViewById(R.id.button);
        first.setOnClickListener(new OpenActivity(FirstActivity.class));
        second = findViewById(R.id.button2);
        second.setOnClickListener(new OpenActivity(SecondActivity.class));
    }
}
