package bg.tu_varna.sit.userdata;

import android.content.Intent;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import bg.tu_varna.sit.userdata.validation.PatternValidator;
import bg.tu_varna.sit.userdata.validation.RangeValidator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView nameValue;
    private EditText name, email, phone, date, height;
    private Button next;
    private PatternValidator patternValidator;
    private RangeValidator rangeValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameValue = findViewById(R.id.textView);
        name = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextEmailAddress);
        phone = findViewById(R.id.editTextPhone);
        date = findViewById(R.id.editTextDate);
        height = findViewById(R.id.editTextNumberDecimal);
        next = findViewById(R.id.button);

        next.setOnClickListener(this::onClick);

        Intent intent = getIntent();
        if (intent != null) {
            String value = intent.getStringExtra("name");
            nameValue.setText(value);
        }
    }

    @Override
    public void onClick(View v) {

        validateName();
        validateEmail();
        validatePhone();
        validateDate();

    }

    private void validateDate() {
        String nameValue = date.getText().toString();
        patternValidator = new PatternValidator("([0-9]{2}.){2}[0-9]{2}");
        if (patternValidator.validate(nameValue)) {
            long min = LocalDateTime.now().minusYears(150)
                    .atZone(ZoneOffset.UTC).toEpochSecond();
            long max = LocalDateTime.now()
                    .atZone(ZoneOffset.UTC).toEpochSecond();
            long now = LocalDateTime
                    .parse(nameValue+" 00:00", DateTimeFormatter.ofPattern("dd.MM.yy HH:mm"))
                    .atZone(ZoneOffset.UTC).toEpochSecond();
            rangeValidator = new RangeValidator(min, max);
            if (!rangeValidator.validate(now)) {
                date.setError("Невалидна дата");
            }
        } else {
            date.setError("Невалидна дата");
        }
    }

    private void validatePhone() {
        String nameValue = phone.getText().toString();
        patternValidator = new PatternValidator("08[0-9]{8}");
        if (!patternValidator.validate(nameValue)) {
            phone.setError("Невалиден телефон");
        }
    }

    private void validateEmail() {
        String nameValue = email.getText().toString();
        String pattern = Patterns.EMAIL_ADDRESS.pattern();
        patternValidator = new PatternValidator(pattern);
        if (!patternValidator.validate(nameValue)) {
            email.setError("Невалиден имейл");
        }
    }

    private void validateName() {
        String nameValue = name.getText().toString();
        patternValidator = new PatternValidator("[a-zA-Z]{2,}");
        if (!patternValidator.validate(nameValue)) {
            name.setError("Невалидно име");
        }
    }
}