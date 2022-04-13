package bg.tu_varna.sit.useraddress;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import bg.tu_varna.sit.useraddress.actions.OnBackAction;
import bg.tu_varna.sit.useraddress.core.BaseActivity;
import bg.tu_varna.sit.useraddress.models.People;

public class AddressActivity extends BaseActivity /*implements View.OnClickListener*/ {

//    @Override
//    public void onClick(View v) {
//        if (v.getId() == next.getId()) {
//            super.onClick(v);
//        }
//        if (v.getId() == back.getId()) {
//            onBackPressed();
//        }
//    }

    private TextView displayName;
    private EditText age, street, city;
    private Button next, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        displayName = findViewById(R.id.textView2);
        displayName.setText(getName());

        age = findViewById(R.id.editTextNumberSigned);
        street = findViewById(R.id.editTextTextMultiLine);
        city = findViewById(R.id.editTextTextPersonName2);

        next = findViewById(R.id.button3);
        next.setOnClickListener(this);

        back = findViewById(R.id.button2);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
        back.setOnLongClickListener(new OnBackAction());
    }

    private String getName() {
        Intent intent = getIntent();
        if (intent == null) {
            return "Невалиден интент";
        }

        return intent.getStringExtra("nameKey");
    }

    @Override
    public Intent createIntent() {

        String nameValue = displayName.getText().toString();

        int ageValue = Integer.parseInt(age.getText().toString().isEmpty()
                ? "0"
                : age.getText().toString());
        String streetValue = street.getText().toString();
        String cityValue = city.getText().toString();

        People people = new People(
                nameValue,
                ageValue,
                streetValue,
                cityValue
        );

        Intent intent = new Intent(this, DisplayActivity.class);

        intent.putExtra("keyPeople", people);

        return intent;
    }
}