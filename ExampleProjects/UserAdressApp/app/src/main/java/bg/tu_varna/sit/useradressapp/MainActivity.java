package bg.tu_varna.sit.useradressapp;

import android.content.Intent;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import bg.tu_varna.sit.useradressapp.core.BaseActivity;
import bg.tu_varna.sit.useradressapp.validators.PatternValidator;

import java.util.regex.Pattern;

public class MainActivity extends BaseActivity {

    private EditText email;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.еmailAddress);
        email.setOnFocusChangeListener(new PatternValidator(Patterns.EMAIL_ADDRESS));

        next = findViewById(R.id.next);
        next.setOnClickListener(this);
    }

    @Override
    public Intent createIntent() {
        email.clearFocus();
        if (email.getError() == null) {
            String text = email.getText().toString();
            Intent intent = new Intent(this, ContactActivity.class);
            intent.putExtra("email", text);
            return intent;
        }
        return null;
    }
}