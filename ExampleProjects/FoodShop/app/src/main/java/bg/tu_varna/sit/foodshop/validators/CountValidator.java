package bg.tu_varna.sit.foodshop.validators;

import android.view.View;
import android.widget.EditText;

public class CountValidator implements View.OnFocusChangeListener {

    private double min;
    private double max;

    public CountValidator(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        String text = ((EditText)v).getText().toString();
        double value = Double.parseDouble(text);
        if (value < min || value > max) {
            ((EditText)v).setError(String.format("Избраното количество трябва да е от %f до %f!", min, max));
        }
    }
}
