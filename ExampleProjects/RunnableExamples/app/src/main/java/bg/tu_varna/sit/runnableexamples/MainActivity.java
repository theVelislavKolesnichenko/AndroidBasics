package bg.tu_varna.sit.runnableexamples;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import bg.tu_varna.sit.runnableexamples.listeners.OnSetTimerListener;
import bg.tu_varna.sit.runnableexamples.listeners.OnValidateLoginListener;
import bg.tu_varna.sit.runnableexamples.models.User;
import bg.tu_varna.sit.runnableexamples.tasks.LoginTask;
import bg.tu_varna.sit.runnableexamples.tasks.TimerTask;
import bg.tu_varna.sit.runnableexamples.tasks.TwoTask;

public class MainActivity extends AppCompatActivity implements OnValidateLoginListener, View.OnClickListener, OnSetTimerListener {

    private EditText email, password;
    private Button login, start, valid;
    private TextView message, timer, validate;
    private ProgressBar progressBar;

    private Handler handler;
    private TimerTask timerTask;

    private int seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.editText);

        progressBar = findViewById(R.id.progressBar);


        login = findViewById(R.id.button);
        login.setOnClickListener(this);


        handler = new Handler(Looper.myLooper());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                runLoginTask();
                break;
        }
    }

    private void runLoginTask() {
        progressBar.setVisibility(View.VISIBLE);
        HandlerThread handlerThread = new HandlerThread("MyHandlerThread");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        Handler handler = new Handler(looper);
        handler.post(new LoginTask(email.getText().toString(), MainActivity.this));
        //new Thread(new LoginTask(email.getText().toString(), MainActivity.this)).start();
    }

    @Override
    public void OnValidateLogin(final boolean isValid) {
        if (!isValid) {
            email.setError("Incorrect login");
        }
        runOnUiThread(() -> {
            if (!isValid) {
                email.setError("Incorrect login");
            }
        });
        progressBar.setVisibility(View.INVISIBLE);
    }








































    private void twoRunnable() {
        progressBar.setVisibility(View.VISIBLE);
        new Thread() {
            @Override
            public void run() {

                TwoTask task = new TwoTask();
                final boolean result = task.Execute();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                        validate.setText(result ? "Corrent" : "Incorrect");
                    }
                });
            }
        }.start();
    }

    private void runTimerTask() {
        if (handler.hasCallbacks(timerTask)) {
            handler.removeCallbacks(timerTask);
        } else {
            handler.post(timerTask);
        }
    }

    @Override
    public void OnSetTimer(int time) {
        seconds += time;
        timer.setText(Integer.toString(seconds));
        handler.postDelayed(timerTask, 1000);
    }
}