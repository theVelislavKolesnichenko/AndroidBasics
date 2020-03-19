package com.github.thevelislavkolesnichenko.customarrayadapter;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.github.thevelislavkolesnichenko.customarrayadapter.adapter.UserAdapter;
import com.github.thevelislavkolesnichenko.customarrayadapter.data.UserSource;
import com.github.thevelislavkolesnichenko.customarrayadapter.models.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Създаване на колекция с потребители
        ArrayList<User> arrayOfUsers = UserSource.generateItemsList();
        // Създаване на адаптер
        UserAdapter adapter = new UserAdapter(this, arrayOfUsers);
        // Поставяне на адаптер за ListView
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
