package bg.tu_varna.sit.issuapplication.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

import bg.tu_varna.sit.issuapplication.R;
import bg.tu_varna.sit.issuapplication.listeners.OnEditIssueListener;
import bg.tu_varna.sit.issuapplication.models.Issue;
import bg.tu_varna.sit.issuapplication.models.Person;
import bg.tu_varna.sit.issuapplication.models.StateType;
import bg.tu_varna.sit.issuapplication.validators.PatternValidator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddIssueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddIssueFragment extends DialogFragment implements View.OnClickListener {
    private OnEditIssueListener listener;
    private EditText name;
    private EditText phone;
    private EditText address;
    private EditText description;

    public AddIssueFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment AddIssueFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddIssueFragment newInstance(OnEditIssueListener listener) {
        AddIssueFragment fragment = new AddIssueFragment();
        fragment.listener = listener;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_issue, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.editTextText);
        name.setOnFocusChangeListener(new PatternValidator(Pattern.compile("[A-Z][a-z]{5,}")));

        phone = view.findViewById(R.id.editTextPhone);
        phone.setOnFocusChangeListener(new PatternValidator(Pattern.compile("0[8,9][0-9]{8}")));

        address = view.findViewById(R.id.editTextTextPostalAddress);
        address.setOnFocusChangeListener(new PatternValidator(Pattern.compile("[a-zA-z0-9]{5,}")));

        description = view.findViewById(R.id.editTextTextMultiLine);
        description.setOnFocusChangeListener(new PatternValidator(Pattern.compile("[a-zA-z0-9]{5,}")));

        Button button = view.findViewById(R.id.button2);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (isValid()) {
            Issue issue = new Issue(
                    new Person(name.getText().toString(), phone.getText().toString()
                    ),
                    description.getText().toString(),
                    address.getText().toString()
            );
            listener.onAddIssue(issue);
            dismiss();
        }
    }

    private boolean isValid() {
        return isValidEditText(this.name)
                && isValidEditText(this.phone)
                && isValidEditText(this.address)
                && isValidEditText(this.description);
    }

    private boolean isValidEditText(EditText editText) {
        return editText != null
                && (editText.getError() == null
                || editText.getError().toString().isEmpty());
    }
}