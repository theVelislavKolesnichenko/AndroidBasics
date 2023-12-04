package bg.tu_varna.sit.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

import bg.tu_varna.sit.contactapp.adapters.ContactAdapter;
import bg.tu_varna.sit.contactapp.listeners.OnAddContactListener;
import bg.tu_varna.sit.contactapp.models.Contact;
import bg.tu_varna.sit.contactapp.sources.ContactSource;

public class MainActivity extends AppCompatActivity implements OnAddContactListener, View.OnClickListener {

    private RecyclerView recyclerView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        ContactAdapter adapter = new ContactAdapter(ContactSource.getContacts(120));

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onAddContact(Contact contact) {
        ContactAdapter adapter = (ContactAdapter) recyclerView.getAdapter();
        Objects.requireNonNull(adapter).addContact(contact);
    }

    @Override
    public void onClick(View v) {
        AddContactFragment fragment = AddContactFragment.newInstance(this);
        fragment.show(getSupportFragmentManager(), "add");
    }
}