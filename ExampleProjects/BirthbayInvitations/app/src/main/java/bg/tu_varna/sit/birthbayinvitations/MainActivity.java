package bg.tu_varna.sit.birthbayinvitations;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import bg.tu_varna.sit.birthbayinvitations.listeners.OnCreateBirthdayCardListener;
import bg.tu_varna.sit.birthbayinvitations.models.BirthdayCard;

public class MainActivity extends AppCompatActivity implements OnCreateBirthdayCardListener {

    private Button create, remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create = findViewById(R.id.button);
        create.setOnClickListener(v -> openDialog());

        remove = findViewById(R.id.button2);
        remove.setOnClickListener(v -> removeFragment());
    }

    private void removeFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag("new");

        if (fragment != null) {
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.remove(fragment);
            transaction.commit();
        }
    }

    private void openDialog() {
        FragmentManager fm = getSupportFragmentManager();
        CreateInvitationFragment createFragment = CreateInvitationFragment.newInstance();
        createFragment.show(fm, "CREATE_NEW_CARD");
    }

    @Override
    public void onCreateBirthdayCard(BirthdayCard card) {
        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction();

        BirthdayCardFragment fragment = BirthdayCardFragment.newInstance(card);
        transaction.add(R.id.frameLayout, fragment, "new");

        transaction.commit();

    }
}