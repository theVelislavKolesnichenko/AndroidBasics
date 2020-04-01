package com.github.thevelislavkolesnichenko.fragmentapplication;


import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.thevelislavkolesnichenko.fragmentapplication.listener.AddAnimalDialogListener;
import com.github.thevelislavkolesnichenko.fragmentapplication.models.Animal;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddAnimalFragment extends DialogFragment implements View.OnClickListener {

    private EditText name;
    private EditText type;
    private EditText image;
    private Button add;
    AddAnimalDialogListener listener;

    public AddAnimalFragment() {
        // Required empty public constructor
    }

    public static AddAnimalFragment newInstance() {
        return new AddAnimalFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_animal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.editText);
        type = view.findViewById(R.id.editText2);
        image = view.findViewById(R.id.editText3);
        add = view.findViewById(R.id.button);
        add.setOnClickListener(this);

        // Фокуситане на курсора за писане върху еditText
        name.requestFocus();
        // Автоматично показване на клавиятурата
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (AddAnimalDialogListener)context;
    }

    @Override
    public void onClick(View v) {
        Animal animal = new Animal(name.getText().toString(), type.getText().toString(), image.getText().toString());

        //AddAnimalDialogListener listener = (AddAnimalDialogListener) getTargetFragment();
        listener.onFinishAddDialog(animal);

        dismiss();
    }
}
