package bg.tu_varna.sit.useraddress;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import bg.tu_varna.sit.useraddress.actions.OnBackAction;
import bg.tu_varna.sit.useraddress.core.BaseActivity;
import bg.tu_varna.sit.useraddress.models.People;

public class DisplayActivity extends BaseActivity  /*implements View.OnClickListener*/ {

//    @Override
//    public void onClick(View v) {
//        if (v.getId() == next.getId()) {
//            super.onClick(v);
//        }
//        if (v.getId() == back.getId()) {
//            onBackPressed();
//        }
//    }
    private TextView display;
    private Button back, next, finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        display = findViewById(R.id.textView3);
        display.setText(getPeople().toString());

        next = findViewById(R.id.next);
        next.setOnClickListener(this);

        back = findViewById(R.id.back);
        //back.setOnClickListener(v -> onBackPressed());
        back.setOnLongClickListener(new OnBackAction());
        finish = findViewById(R.id.finish);
        finish.setOnClickListener(v -> finishAndRemoveTask());
    }

    private People getPeople() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getParcelableExtra("keyPeople");
        }

        return People.EMPTY;
    }

    @Override
    public Intent createIntent() {
        return null;
    }
}