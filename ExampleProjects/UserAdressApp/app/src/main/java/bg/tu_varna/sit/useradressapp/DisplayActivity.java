package bg.tu_varna.sit.useradressapp;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import bg.tu_varna.sit.useradressapp.core.BaseActivity;
import bg.tu_varna.sit.useradressapp.events.OnBackEvent;
import bg.tu_varna.sit.useradressapp.models.People;

public class DisplayActivity extends BaseActivity {

    private TextView display;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        display = findViewById(R.id.textView2);
        display.setText(getIntentExtra());

        back = findViewById(R.id.back);
        back.setOnLongClickListener(new OnBackEvent(this));
    }

    private String getIntentExtra() {
        Intent intent = getIntent();
        if (intent != null) {
            People people = intent.getParcelableExtra("people");
            return people.toString();
        }
        return "Липсват данн в интента";
    }

    @Override
    public Intent createIntent() {
        return null;
    }
}