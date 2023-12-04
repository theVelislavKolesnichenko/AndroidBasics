package bg.tu_varna.sit.issuapplication.validators;

import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

import bg.tu_varna.sit.issuapplication.R;

public class PatternValidator implements View.OnFocusChangeListener {
    private final Pattern pattern;

    public PatternValidator(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        EditText editText = (EditText) v;
        String value = editText.getText().toString();
        if (!pattern.matcher(value).matches()) {
            editText.setError(v.getContext().getString(R.string.invalid_data));
        }
    }
}
