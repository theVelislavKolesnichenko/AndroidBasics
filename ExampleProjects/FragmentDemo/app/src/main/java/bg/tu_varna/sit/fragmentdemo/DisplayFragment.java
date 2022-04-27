package bg.tu_varna.sit.fragmentdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bg.tu_varna.sit.fragmentdemo.models.Invitation;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisplayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayFragment extends Fragment {

    private static final String ARG_INVITATION = "invitation";

    private Invitation invitation;

    private DisplayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param invitation Parameter 1.
     * @return A new instance of fragment DisplayFragment.
     */
    public static DisplayFragment newInstance(Invitation invitation) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_INVITATION, invitation);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            invitation = getArguments().getParcelable(ARG_INVITATION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView name = view.findViewById(R.id.textView2);
        TextView message = view.findViewById(R.id.textView3);
        TextView to = view.findViewById(R.id.textView);

        name.setText(invitation.getName());
        message.setText(invitation.getMessage());
        to.setText(invitation.getBurnMessage());

        Random rnd = new Random();
        Integer color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        view.setBackgroundColor(color);
    }
}