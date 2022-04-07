package bg.tu_varna.sit.userdata;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class NameActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        name = findViewById(R.id.editTextTextPersonName2);
        next = findViewById(R.id.button2);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nameValue = name.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("name", nameValue);
        startActivity(intent);
    }
}