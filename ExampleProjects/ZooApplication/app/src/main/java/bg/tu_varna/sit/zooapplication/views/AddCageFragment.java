package bg.tu_varna.sit.zooapplication.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import bg.tu_varna.sit.zooapplication.R;
import bg.tu_varna.sit.zooapplication.listeners.OnAddCageListener;
import bg.tu_varna.sit.zooapplication.models.Cage;
import bg.tu_varna.sit.zooapplication.models.CageType;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddCageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddCageFragment extends DialogFragment {
    private OnAddCageListener listener;
    private AddCageFragment(OnAddCageListener listener) {
        this.listener = listener;
    }
    public static AddCageFragment newInstance(OnAddCageListener listener) {
       return new AddCageFragment(listener);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_cage, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText text = view.findViewById(R.id.editTextText);
        Button button = view.findViewById(R.id.button2);
        button.setOnClickListener(r -> {
            Cage cage = getCage(text);
            if (cage != null) {
                listener.OnAddCage(cage);
                dismiss();
            }
        });
    }

    private Cage getCage(EditText text) {
        String typeName = text.getText().toString();
        Cage cage = null;
        try {
            CageType type = CageType.valueOf(typeName);
            cage = new Cage(type);
        } catch (Exception ex) {

        }
        return cage;
    }
}