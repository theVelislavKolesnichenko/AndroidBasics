package bg.tu_varna.sit.issuapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import bg.tu_varna.sit.issuapplication.adapters.IssueAdapter;
import bg.tu_varna.sit.issuapplication.listeners.OnEditIssueListener;
import bg.tu_varna.sit.issuapplication.models.Issue;
import bg.tu_varna.sit.issuapplication.views.AddIssueFragment;
import bg.tu_varna.sit.issuapplication.views.EditIssueFragment;

public class MainActivity extends AppCompatActivity implements OnEditIssueListener, View.OnClickListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        this.recyclerView.setAdapter(new IssueAdapter(new ArrayList<>()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.button)
                .setOnClickListener(this);
    }

    @Override
    public void onAddIssue(Issue issue) {
        IssueAdapter adapter = (IssueAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.addIssue(issue);
        }
    }

    @Override
    public void onEditIssue(Issue issue) {
        IssueAdapter adapter = (IssueAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            issue.nextState();
            adapter.changed(issue);
        }
    }

    @Override
    public void onClick(View v) {
        AddIssueFragment fragment = AddIssueFragment.newInstance(this);
        fragment.show(getSupportFragmentManager(), "add");
    }
}