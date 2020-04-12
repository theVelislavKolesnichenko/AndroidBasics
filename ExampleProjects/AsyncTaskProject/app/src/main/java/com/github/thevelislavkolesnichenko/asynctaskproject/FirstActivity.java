package com.github.thevelislavkolesnichenko.asynctaskproject;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.github.thevelislavkolesnichenko.asynctaskproject.listener.LoaderListener;
import com.github.thevelislavkolesnichenko.asynctaskproject.tasks.LoaderAsyncTask;

public class FirstActivity extends AppCompatActivity implements LoaderListener {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoaderAsyncTask task = new LoaderAsyncTask(getSupportFragmentManager(), FirstActivity.this);
                task.execute(Integer.parseInt(editText.getText().toString()));
            }
        });
    }

    @Override
    public void ResultUpdate(String s) {
        textView.setText(s);
        textView.setTextColor(Color.GREEN);
    }
}
