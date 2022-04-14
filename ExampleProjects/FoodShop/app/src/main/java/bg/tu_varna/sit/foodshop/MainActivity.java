package bg.tu_varna.sit.foodshop;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import bg.tu_varna.sit.foodshop.events.OnNextEvent;
import bg.tu_varna.sit.foodshop.interfaces.OnIntentCreat;
import bg.tu_varna.sit.foodshop.validators.SizeValidator;

public class MainActivity extends AppCompatActivity implements OnIntentCreat {

    private EditText shopName;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shopName = findViewById(R.id.shopName);
        shopName.setOnFocusChangeListener(new SizeValidator(5, 100));
        next = findViewById(R.id.next);
        next.setOnLongClickListener(new OnNextEvent(this));
    }

    @Override
    public Intent onCreateIntent() {
        String text = shopName.getText().toString();
        if (text.isEmpty() || shopName.getError() != null) {
            return null;
        }
        Intent intent = new Intent(this, ShopActivity.class);
        intent.putExtra("shopName", text);
        return intent;
    }
}