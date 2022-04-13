package bg.tu_varna.sit.useraddress.actions;

import android.app.Activity;
import android.view.View;

public class OnBackAction implements View.OnLongClickListener {
    @Override
    public boolean onLongClick(View v) {
        ((Activity)v.getContext()).onBackPressed();
        return true;
    }
}
