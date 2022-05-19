package bg.tu_varna.sit.examprojectv1;

import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bg.tu_varna.sit.examprojectv1.adapters.NewsItemAdapter;
import bg.tu_varna.sit.examprojectv1.data.Repository;
import bg.tu_varna.sit.examprojectv1.listeners.OnCreateNewsListener;
import bg.tu_varna.sit.examprojectv1.models.News;
import bg.tu_varna.sit.examprojectv1.tasks.CreateNews;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        OnCreateNewsListener {

    private RecyclerView recyclerView;
    private Button next;

    private HandlerThread handlerThread;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        next = findViewById(R.id.button);
        next.setOnClickListener(this);

        NewsItemAdapter adapter
                = new NewsItemAdapter(Repository.generateNews(3));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        handlerThread = new HandlerThread("News");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
        handler.postDelayed(
                new CreateNews(this), 500);
    }

    @Override
    public void onCreateNews(News news) {

        runOnUiThread(() -> setNewsInView(news));

        handler.postDelayed(
                new CreateNews(this), 500);

    }

    @Override
    public void onClick(View v) {
        News news = Repository.createNews(100);
        setNewsInView(news);
    }

    private void setNewsInView(News news) {
        NewsItemAdapter adapter = (NewsItemAdapter) recyclerView.getAdapter();

        adapter.addNews(news);


        //title.setText(news.getTitle());
        //content.setText(news.getContent());
    }
}