package bg.tu_varna.sit.issuapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bg.tu_varna.sit.issuapplication.MainActivity;
import bg.tu_varna.sit.issuapplication.R;
import bg.tu_varna.sit.issuapplication.models.Issue;
import bg.tu_varna.sit.issuapplication.models.StateType;
import bg.tu_varna.sit.issuapplication.views.EditIssueFragment;
import bg.tu_varna.sit.issuapplication.views.IssueViewHolder;

public class IssueAdapter extends RecyclerView.Adapter<IssueViewHolder> {

    private final List<Issue> issues;
    private Context context;
    public IssueAdapter(List<Issue> issues) {
        this.issues = issues;
    }

    @NonNull
    @Override
    public IssueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.issue_view, parent, false);

        return new IssueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IssueViewHolder holder, int position) {
        Issue issue = issues.get(position);

        holder.setTextView(issue.getAddress());

        holder.setBackgroundColor(getColor(issue));

        holder.setOnClickListener(v -> {
            EditIssueFragment fragment = EditIssueFragment.newInstance(issue, (MainActivity)context);
            fragment.show(((MainActivity)context).getSupportFragmentManager(), "edit");
        });
    }

    private int getColor(Issue issue) {
        switch (issue.getState()) {
            case PROGRESS: return Color.YELLOW;
            case DONE: return Color.GREEN;
            default:
            case TODO: return Color.RED;
        }
    }

    @Override
    public int getItemCount() {
        return this.issues.size();
    }

    public void addIssue(Issue issue) {
        this.issues.add(issue);
        notifyItemChanged(this.issues.size() - 1);
    }

    public void changed(Issue issue) {
        int position = this.issues.indexOf(issue);
        notifyItemChanged(position);
    }
}
