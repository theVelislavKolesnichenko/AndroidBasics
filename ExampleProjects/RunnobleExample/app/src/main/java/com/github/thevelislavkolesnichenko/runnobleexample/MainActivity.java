package com.github.thevelislavkolesnichenko.runnobleexample;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.github.thevelislavkolesnichenko.runnobleexample.listeners.OnValidateLoginListener;
import com.github.thevelislavkolesnichenko.runnobleexample.models.User;
import com.github.thevelislavkolesnichenko.runnobleexample.tasks.LoginTask;

public class MainActivity extends AppCompatActivity implements OnValidateLoginListener, View.OnClickListener {

    private Button button1, button2, button3;
    private EditText editText1, editText2;
    private TextView textView1, textView2, textView3;
    Handler handler = new Handler();
    int timer = 0;
    Runnable runnable = new Runnable() {
        public void run() {
            textView2.setText(Integer.toString(timer++));
            handler.postDelayed(this, 1000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView5);
        textView3 = findViewById(R.id.textView7);

        textView3.setText(Integer.toString(android.os.Build.VERSION.SDK_INT));

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                runFirstThread();
                break;
            case R.id.button2: {
                if (handler.hasCallbacks(runnable)) {
                    handler.removeCallbacks(runnable);
                } else {
                    handler.post(runnable);
                }
            }
                break;
            case R.id.button3:
                break;
        }
    }

    private void runFirstThread() {
        new Thread() {
            @Override
            public void run() {
                runOnUiThread(new LoginTask(MainActivity.this, new User(editText1.getText().toString(), editText2.getText().toString())));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public void OnValidateLogin(boolean isValid) {
        textView1.setText(isValid ? "Correct login" : "Incorrect login");
    }
}
