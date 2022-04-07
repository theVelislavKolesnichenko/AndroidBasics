package bg.tu_varna.sit.useraddress;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import bg.tu_varna.sit.useraddress.core.BaseActivity;
import bg.tu_varna.sit.useraddress.valitators.PatternValidator;

public class MainActivity extends BaseActivity {

    private EditText name;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextTextPersonName);
        new PatternValidator("[a-zA-Z]{2,} [a-zA-Z]{2,}", name);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public Intent createIntent() {
        CharSequence error = name.getError();
        if (error != null && !error.toString().isEmpty()) {
            return null;
        }

        Intent intent = new Intent(this, AddressActivity.class);
        intent.putExtra("nameKey", name.getText().toString());
        return intent;
    }
}