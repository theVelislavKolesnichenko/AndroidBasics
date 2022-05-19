package bg.tu_varna.sit.recyclerviewexample;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bg.tu_varna.sit.recyclerviewexample.adapters.CustomRecyclerViewAdapter;
import bg.tu_varna.sit.recyclerviewexample.date.Storage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        CustomRecyclerViewAdapter customRecyclerViewAdapter =
                new CustomRecyclerViewAdapter(Storage.generate(150));

        recyclerView.setAdapter(customRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CustomRecyclerViewAdapter adapter =
                (CustomRecyclerViewAdapter) recyclerView.getAdapter();
        adapter.update(Storage.generate(50));
    }
}