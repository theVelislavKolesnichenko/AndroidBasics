package bg.tu_varna.sit.contactapp;

import android.content.Context;
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

import bg.tu_varna.sit.contactapp.listeners.OnAddContactListener;
import bg.tu_varna.sit.contactapp.models.Contact;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddContactFragment extends DialogFragment implements View.OnClickListener {

    private EditText name;
    private EditText phone;

    private OnAddContactListener listener;

    public AddContactFragment(OnAddContactListener listener) {
        // Required empty public constructor
        this.listener = listener;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddContactFragment newInstance(OnAddContactListener listener) {
        return new AddContactFragment(listener);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.name = view.findViewById(R.id.editTextText);
        this.phone = view.findViewById(R.id.editTextPhone);
        Button button = view.findViewById(R.id.button2);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Contact contact = new Contact(
          name.getText().toString(),
          Long.parseLong(phone.getText().toString())
        );

        listener.onAddContact(contact);
        dismiss();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnAddContactListener) {
            listener = (OnAddContactListener) context;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
     }
}