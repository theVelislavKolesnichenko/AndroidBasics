package bg.tu_varna.sit.foodshop.validators;

import android.view.View;
import android.widget.EditText;

public class SizeValidator implements View.OnFocusChangeListener {

    private double min;
    private double max;

    public SizeValidator(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        String text = ((EditText)v).getText().toString();
        if (text.length() < min || text.length() > max) {
            ((EditText)v).setError(String.format("Дължината на стойноста трябва да е от %f до %f!", min, max));
        }
    }
}
