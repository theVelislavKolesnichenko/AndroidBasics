package bg.tu_varna.sit.useradressapp.core;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "19620000";

    public abstract Intent createIntent();

    @Override
    public void onClick(View v) {
        Log.i(TAG, getLog("onClick"));
        Intent intent = createIntent();
        if (intent != null) {
            startActivity(intent);
        }
    }

    private String getLog(String event) {
        return String.format("%s: %s ", event, this.getClass().getName());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, getLog("onCreate"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, getLog("onStart"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, getLog("onStop"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, getLog("onDestroy"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, getLog("onResume"));
    }


}
