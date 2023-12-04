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
import android.widget.TextView;

import bg.tu_varna.sit.issuapplication.R;
import bg.tu_varna.sit.issuapplication.listeners.OnEditIssueListener;
import bg.tu_varna.sit.issuapplication.models.Issue;
import bg.tu_varna.sit.issuapplication.models.StateType;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditIssueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditIssueFragment extends DialogFragment implements View.OnClickListener {
    private static final String ISSUE = "issue";
    private Issue issue;
    private final OnEditIssueListener listener;

    private EditIssueFragment(OnEditIssueListener listener) {
        this.listener = listener;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EditIssueFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditIssueFragment newInstance(Issue issue, OnEditIssueListener listener) {
        EditIssueFragment fragment = new EditIssueFragment(listener);
        Bundle args = new Bundle();
        args.putParcelable(ISSUE, issue);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            issue = getArguments().getParcelable(ISSUE, Issue.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_issue, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.textView3);
        textView.setText(issue.toString());

        Button button = view.findViewById(R.id.button3);
        button.setText(getButtonName());
        button.setVisibility(getVisibility());
        button.setOnClickListener(this);
    }

    private String getButtonName() {
        return issue.getState() == StateType.TODO
                ? getString(R.string.start_progress)
                : issue.getState() == StateType.PROGRESS
                ? getString(R.string.done)
                : "";
    }

    private int getVisibility() {
        return issue.getState() == StateType.TODO || issue.getState() == StateType.PROGRESS
                ? View.VISIBLE
                : View.INVISIBLE;
    }

    @Override
    public void onClick(View v) {
        listener.onEditIssue(issue);
        dismiss();
    }
}