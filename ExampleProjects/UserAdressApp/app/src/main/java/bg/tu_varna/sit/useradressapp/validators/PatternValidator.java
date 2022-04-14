package bg.tu_varna.sit.useradressapp.validators;

import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

public class PatternValidator implements View.OnFocusChangeListener {

    private Pattern pattern;

    public PatternValidator(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        EditText editText = (EditText) v;
        String text = editText.getText().toString();
        if (!pattern.matcher(text).matches()) {
            editText.setError("Навалидно въведена стойност");
        }
    }
}
