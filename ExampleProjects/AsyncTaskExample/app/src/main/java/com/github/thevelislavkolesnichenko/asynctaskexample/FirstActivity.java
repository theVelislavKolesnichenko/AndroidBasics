package com.github.thevelislavkolesnichenko.asynctaskexample;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.github.thevelislavkolesnichenko.asynctaskexample.listener.LoaderListener;
import com.github.thevelislavkolesnichenko.asynctaskexample.tasks.LoaderAsyncTask;

public class FirstActivity extends AppCompatActivity implements LoaderListener {

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText2);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoaderAsyncTask as = new LoaderAsyncTask(getSupportFragmentManager(), FirstActivity.this);
                Integer[] ints = new Integer[] {Integer.parseInt(editText.getText().toString())};
                as.execute(Integer.parseInt(editText.getText().toString()));
            }
        });
    }

    @Override
    public void Result(String value) {
        textView.setText(value);
        textView.setTextColor(Color.GREEN);
    }
}
