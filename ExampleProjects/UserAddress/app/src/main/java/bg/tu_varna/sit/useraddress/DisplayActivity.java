package bg.tu_varna.sit.useraddress;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import bg.tu_varna.sit.useraddress.core.BaseActivity;
import bg.tu_varna.sit.useraddress.models.People;

public class DisplayActivity extends BaseActivity {

    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        display = findViewById(R.id.textView3);
        display.setText(getPeople().toString());
    }

    private People getPeople() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getParcelableExtra("keyPeople");
        }

        return People.EMPTY;
    }

    @Override
    public Intent createIntent() {
        return null;
    }
}