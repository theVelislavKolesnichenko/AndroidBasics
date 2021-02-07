package com.github.thevelislavkolesnichenko.dashboardapp;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.gridlayout.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.gridLayout);

        setSingleEvent(gridLayout);
    }

    private void setSingleEvent(GridLayout gridLayout) {
        for (int index = 0; index < gridLayout.getChildCount(); index++) {
            CardView cardView = (CardView) gridLayout.getChildAt(index);
            cardView.setOnClickListener(new OpenActivity(getActivityByGridId(cardView.getId())));
        }
    }

    private Class getActivityByGridId(int id) {
        switch (id) {
            case R.id.cardView1:
                return IncomeActivity.class;
            case R.id.cardView2:
                return ExpenditureActivity.class;
            case R.id.cardView3:
                return EventsActivity.class;
            case R.id.cardView4:
                return DatePickerActivity.class;
            case R.id.cardView5:
                return WarehouseReportActivity.class;
            case R.id.cardView6:
                return SettingsActivity.class;
            default:
                return LauncherActivity.class;
        }
    }
}
