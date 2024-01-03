package bg.tu_varna.sit.issuapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import bg.tu_varna.sit.issuapplication.adapters.IssueAdapter;
import bg.tu_varna.sit.issuapplication.listeners.OnEditIssueListener;
import bg.tu_varna.sit.issuapplication.models.Issue;
import bg.tu_varna.sit.issuapplication.tasks.AddIssueTask;
import bg.tu_varna.sit.issuapplication.views.AddIssueFragment;

public class MainActivity extends AppCompatActivity implements OnEditIssueListener, View.OnClickListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Issue> issueList = new ArrayList<>();

        HandlerThread thread = new HandlerThread("Issues");
        thread.start();

        Handler handler = new Handler(thread.getLooper());
        handler.post(new AddIssueTask(this));

        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        new AddIssueTask(MainActivity.this).run();
                        handler.post(this);
                    }
                }
                );

        recyclerView = findViewById(R.id.recyclerView);
        this.recyclerView.setAdapter(new IssueAdapter(issueList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.button)
                .setOnClickListener(this);
    }

    @Override
    public void onAddIssue(Issue issue) {
        IssueAdapter adapter = (IssueAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter.addIssue(issue);
                }
            });
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