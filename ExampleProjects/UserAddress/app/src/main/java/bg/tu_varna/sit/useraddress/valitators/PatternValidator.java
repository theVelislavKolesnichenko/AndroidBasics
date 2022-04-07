package bg.tu_varna.sit.useraddress.valitators;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

public class PatternValidator implements TextWatcher {

    private Pattern pattern;
    private EditText editText;

    public PatternValidator(String pattern, EditText view) {
        this.pattern = Pattern.compile(pattern);
        this.editText = view;
        this.editText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!pattern.matcher(s).matches()) {
            editText.setError("Невалидно попълнени данни");
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
