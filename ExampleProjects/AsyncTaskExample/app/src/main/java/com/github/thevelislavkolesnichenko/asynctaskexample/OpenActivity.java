package com.github.thevelislavkolesnichenko.asynctaskexample;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class OpenActivity implements View.OnClickListener {

    Class activity;

    public OpenActivity(Class activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        v.getContext().startActivity(new Intent(v.getContext(), activity));
    }
}
