package bg.tu_varna.sit.foodshop;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import bg.tu_varna.sit.foodshop.events.OnBackEvent;
import bg.tu_varna.sit.foodshop.events.OnNextEvent;
import bg.tu_varna.sit.foodshop.interfaces.OnIntentCreat;
import bg.tu_varna.sit.foodshop.models.Product;
import bg.tu_varna.sit.foodshop.validators.CountValidator;
import bg.tu_varna.sit.foodshop.validators.SizeValidator;

public class ShopActivity extends AppCompatActivity implements OnIntentCreat {

    private EditText productName, productPrice, productSize;
    private Button next, back;
    private TextView shopName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        productName = findViewById(R.id.productName);
        productName.setOnFocusChangeListener(new SizeValidator(5, 150));
        productPrice = findViewById(R.id.productPrice);
        productPrice.setOnFocusChangeListener(new CountValidator(0.5, 2.5));
        productSize = findViewById(R.id.productSize);
        productSize.setOnFocusChangeListener(new CountValidator(1, 1000));

        next = findViewById(R.id.next);
        next.setOnLongClickListener(new OnNextEvent(this));
        back = findViewById(R.id.back);
        back.setOnTouchListener(new OnBackEvent(this));

        shopName = findViewById(R.id.name);
        shopName.setText(getIntentExtra());

    }

    private String getIntentExtra() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getStringExtra("shopName");
        }
        return "";
    }

    @Override
    public Intent onCreateIntent() {
        String shopNameValue = shopName.getText().toString();
        String productNameValue = productName.getText().toString();
        String productPriceValue = productPrice.getText().toString();
        String productSizeValue = productSize.getText().toString();

        if (shopNameValue.isEmpty() ||
                productNameValue.isEmpty() ||
                productPriceValue.isEmpty() ||
                productSizeValue.isEmpty() ||
                productName.getError() != null ||
                productPrice.getError() != null ||
                productSize.getError() != null
        ) {
            return null;
        }

        Intent intent = new Intent(this, DisplayActivity.class);

        Product product = new Product(
                shopNameValue,
                productNameValue,
                productPriceValue,
                productSizeValue
        );

        intent.putExtra("product", product);

        return intent;
    }
}