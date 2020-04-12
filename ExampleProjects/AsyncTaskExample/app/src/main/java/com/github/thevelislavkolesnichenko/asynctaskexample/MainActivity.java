package com.github.thevelislavkolesnichenko.asynctaskexample;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button first, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = findViewById(R.id.button2);
        first.setOnClickListener(new OpenActivity(FirstActivity.class));
        second = findViewById(R.id.button3);
        second.setOnClickListener(new OpenActivity(SecondActivity.class));
    }
}
