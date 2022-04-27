package bg.tu_varna.sit.fragmentdemo;

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
import bg.tu_varna.sit.fragmentdemo.interfaces.OnCreateInvitationListener;
import bg.tu_varna.sit.fragmentdemo.models.Invitation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateFragment extends DialogFragment {

    private EditText name;
    private EditText age;
    private EditText message;
    private OnCreateInvitationListener onCreateInvitation;


    private CreateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CreateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateFragment newInstance() {
        CreateFragment fragment = new CreateFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        name = view.findViewById(R.id.editTextTextPersonName2);
        age = view.findViewById(R.id.editTextNumberSigned);
        message = view.findViewById(R.id.editTextTextMultiLine);

        Button back = view.findViewById(R.id.button4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        Button save = view.findViewById(R.id.button3);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateInvitation.onCreateInvitation(new Invitation(
                        name.getText().toString(),
                        Integer.parseInt(age.getText().toString()),
                        message.getText().toString()
                ));
                dismiss();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (!(context instanceof OnCreateInvitationListener)) {
            throw new RuntimeException(context.toString() + " must implement OnCreateInvitation");
        }

        onCreateInvitation = (OnCreateInvitationListener) context;
    }
}