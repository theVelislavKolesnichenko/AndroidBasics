package bg.tu_varna.sit.useradressapp;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import bg.tu_varna.sit.useradressapp.core.BaseActivity;

public class LauncherActivity extends BaseActivity {

    private Button start;

    @Override
    public Intent createIntent() {
        return new Intent(this, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        start = findViewById(R.id.start);
        start.setOnClickListener(this);
    }
}