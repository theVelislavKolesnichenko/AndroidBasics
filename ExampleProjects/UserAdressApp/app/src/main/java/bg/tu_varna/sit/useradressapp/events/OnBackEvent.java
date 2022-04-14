package bg.tu_varna.sit.useradressapp.events;

import android.app.Activity;
import android.view.View;

public class OnBackEvent implements View.OnLongClickListener {

    private Activity activity;

    public OnBackEvent(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onLongClick(View v) {
        activity.onBackPressed();
        return false;
    }
}
