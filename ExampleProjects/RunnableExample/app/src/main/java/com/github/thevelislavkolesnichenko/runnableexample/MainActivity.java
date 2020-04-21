package com.github.thevelislavkolesnichenko.runnableexample;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.github.thevelislavkolesnichenko.runnableexample.listeners.OnSetTimerListener;
import com.github.thevelislavkolesnichenko.runnableexample.listeners.OnValidateLoginListener;
import com.github.thevelislavkolesnichenko.runnableexample.models.User;
import com.github.thevelislavkolesnichenko.runnableexample.tasks.LoginTask;
import com.github.thevelislavkolesnichenko.runnableexample.tasks.TimerTask;

public class MainActivity extends AppCompatActivity implements OnValidateLoginListener, View.OnClickListener, OnSetTimerListener {

    private EditText email, password;
    private Button login, start;
    private TextView message, timer;
    private Handler handler;
    private TimerTask timerTask;

    private int seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        message = findViewById(R.id.textView);

        login = findViewById(R.id.button);
        login.setOnClickListener(this);

        timer = findViewById(R.id.textView2);

        start = findViewById(R.id.button2);
        start.setOnClickListener(this);

        handler = new Handler();
        timerTask = new TimerTask(this);

        seconds = -1;

    }

    @Override
    public void OnValidateLogin(boolean isValid) {
        message.setText(isValid ? "Corrent login" : "Incorrect login");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                runLoginTask();
            break;
            case R.id.button2:
                runTimerTask();
            break;
        }
    }

    private void runTimerTask() {
        if(handler.hasCallbacks(timerTask)) {
            handler.removeCallbacks(timerTask);
        } else {
            handler.post(timerTask);
        }
    }

    private void runLoginTask() {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new LoginTask(new User(email.getText().toString(), password.getText().toString()), MainActivity.this));

            }
        }.start();
    }

    @Override
    public void OnSetTimer(int time) {
        seconds += time;
        timer.setText(Integer.toString(seconds));
        handler.postDelayed(timerTask, 1000);
    }
}
