package bg.tu_varna.sit.useradressapp;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import bg.tu_varna.sit.useradressapp.core.BaseActivity;
import bg.tu_varna.sit.useradressapp.events.OnBackEvent;
import bg.tu_varna.sit.useradressapp.models.People;
import bg.tu_varna.sit.useradressapp.validators.PatternValidator;

import java.util.regex.Pattern;

public class ContactActivity extends BaseActivity {

    private EditText name, address, phone;
    private Button back, next;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        name = findViewById(R.id.name);
        name.setOnFocusChangeListener(new PatternValidator(Pattern.compile("[a-zA-Z]{2,100}")));
        address = findViewById(R.id.postalAddress);
        address.setOnFocusChangeListener(new PatternValidator(Pattern.compile("[a-zA-Z]{5,255}")));
        phone = findViewById(R.id.phone);
        phone.setOnFocusChangeListener(new PatternValidator(Pattern.compile("08[0-9]{8}")));

        back = findViewById(R.id.back);
        back.setOnLongClickListener(new OnBackEvent(this));
        next = findViewById(R.id.next);
        next.setOnClickListener(this);
        email = findViewById(R.id.emailAddress);
        email.setText(getIntentExtra());
    }

    private String getIntentExtra() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getStringExtra("email");
        }
        return "";
    }

    @Override
    public Intent createIntent() {
        name.clearFocus();
        address.clearFocus();
        phone.clearFocus();
        if (name.getError() == null &&
                address.getError() == null &&
                phone.getError() == null) {
            Intent intent = new Intent(this, DisplayActivity.class);

            People people = new People(
                    email.getText().toString(),
                    name.getText().toString(),
                    address.getText().toString(),
                    phone.getText().toString()
            );

            intent.putExtra("people", people);

            return intent;
        }
        return null;
    }
}