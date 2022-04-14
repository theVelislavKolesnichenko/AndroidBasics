package bg.tu_varna.sit.foodshop.events;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import bg.tu_varna.sit.foodshop.interfaces.OnIntentCreat;

public class OnNextEvent implements View.OnLongClickListener {

    private final static String TAG = "19620000";
    private OnIntentCreat onIntentCreat;

    public OnNextEvent(OnIntentCreat onIntentCreat) {
        this.onIntentCreat = onIntentCreat;
    }

    @Override
    public boolean onLongClick(View v) {
        Log.d(TAG, String.format("onLongClick: %s", v.getId()));
        Intent intent = onIntentCreat.onCreateIntent();
        if (intent != null) {
            if (onIntentCreat instanceof Activity) {
                ((Activity)onIntentCreat).startActivity(intent);
            }
        }
        return true;
    }
}
