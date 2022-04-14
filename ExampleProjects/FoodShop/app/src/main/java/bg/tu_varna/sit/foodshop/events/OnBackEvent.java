package bg.tu_varna.sit.foodshop.events;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;

public class OnBackEvent implements View.OnTouchListener {

    private Activity activity;

    public OnBackEvent(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        activity.onBackPressed();
        return true;
    }
}
