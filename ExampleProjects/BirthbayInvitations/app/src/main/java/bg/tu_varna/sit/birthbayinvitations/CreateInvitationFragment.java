package bg.tu_varna.sit.birthbayinvitations;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bg.tu_varna.sit.birthbayinvitations.listeners.OnCreateBirthdayCardListener;
import bg.tu_varna.sit.birthbayinvitations.models.BirthdayCard;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateInvitationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateInvitationFragment extends DialogFragment {

    private Button back, create;
    private EditText name, age, message;

    private OnCreateBirthdayCardListener listener;

    private CreateInvitationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CreateInvitationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateInvitationFragment newInstance() {
        return new CreateInvitationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_invitation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.editTextTextPersonName);
        age = view.findViewById(R.id.editTextNumberSigned);
        message = view.findViewById(R.id.editTextTextMultiLine);

        back = view.findViewById(R.id.button4);
        back.setOnClickListener(v -> dismiss());

        create = view.findViewById(R.id.button3);
        create.setOnClickListener(v -> {
            listener.onCreateBirthdayCard(new BirthdayCard(
                    name.getText().toString(),
                    message.getText().toString(),
                    Integer.parseInt(age.getText().toString())
            ));
            dismiss();
            });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (!(context instanceof OnCreateBirthdayCardListener)) {
            throw new RuntimeException("Context is not OnCreateBirthdayCardListener");
        }

        listener = (OnCreateBirthdayCardListener) context;
    }
}