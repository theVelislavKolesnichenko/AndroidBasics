package bg.tu_varna.sit.zooapplication.views;

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

import bg.tu_varna.sit.zooapplication.R;
import bg.tu_varna.sit.zooapplication.listeners.OnAddAnimalListener;
import bg.tu_varna.sit.zooapplication.models.Animal;
import bg.tu_varna.sit.zooapplication.models.Cage;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddAnimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddAnimalFragment extends DialogFragment implements View.OnClickListener {
    private static final String CAGE = "cagee";
    private final OnAddAnimalListener listener;

    private EditText name;
    private EditText breed;
    private EditText consumption;
    private EditText weight;

    private Cage cage;

    public AddAnimalFragment(OnAddAnimalListener listener) {
        this.listener = listener;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param cage Parameter 1.
     * @return A new instance of fragment AddAnimalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddAnimalFragment newInstance(Cage cage, OnAddAnimalListener listener) {
        AddAnimalFragment fragment = new AddAnimalFragment(listener);
        Bundle args = new Bundle();
        args.putParcelable(CAGE, cage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cage = getArguments().getParcelable(CAGE, Cage.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_animal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.editTextText5);
        breed = view.findViewById(R.id.editTextText6);
        consumption = view.findViewById(R.id.editTextNumberSigned5);
        weight = view.findViewById(R.id.editTextNumberSigned6);

        Button button = view.findViewById(R.id.button4);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        this.cage.addAnimal(getAnimal());
        listener.onUpdate();
        dismiss();
    }

    private Animal getAnimal() {
        return new Animal(
                getValue(this.name),
                getValue(this.breed),
                Float.parseFloat(getValue(this.consumption)),
                Float.parseFloat(getValue(this.weight))
        );
    }

    private String getValue(EditText text) {
        return text.getText().toString();
    }
}