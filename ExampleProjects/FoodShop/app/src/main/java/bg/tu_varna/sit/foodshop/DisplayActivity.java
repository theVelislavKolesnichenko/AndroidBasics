package bg.tu_varna.sit.foodshop;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import bg.tu_varna.sit.foodshop.events.OnBackEvent;

public class DisplayActivity extends AppCompatActivity {

    private TextView display;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        display = findViewById(R.id.display);

        back = findViewById(R.id.back);
        back.setOnTouchListener(new OnBackEvent(this));

        display.setText(getIntentExtra());
    }

    private String getIntentExtra() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getParcelableExtra("product").toString();
        }

        return "Липсват данни";
    }
}