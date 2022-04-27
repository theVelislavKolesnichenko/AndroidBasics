package bg.tu_varna.sit.fragmentdemo;

import android.view.SurfaceControl;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import bg.tu_varna.sit.fragmentdemo.interfaces.OnCreateInvitationListener;
import bg.tu_varna.sit.fragmentdemo.models.Invitation;

public class MainActivity extends AppCompatActivity implements OnCreateInvitationListener {

    private Button open, remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        open = findViewById(R.id.button);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                CreateFragment fragment = CreateFragment.newInstance();
                fragment.show(fm, "fragment_add_animal");
            }
        });

        remove = findViewById(R.id.button2);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayFragment currentFragment = (DisplayFragment) getSupportFragmentManager().findFragmentByTag("new");
                if (currentFragment != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .remove(currentFragment)
                            .commit();
                }
            }
        });
    }

    @Override
    public void onCreateInvitation(Invitation invitation) {
        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction();

        DisplayFragment displayFragment = DisplayFragment.newInstance(invitation);

        transaction.add(R.id.frameLayout, displayFragment, "new");

        transaction.commit();
    }
}