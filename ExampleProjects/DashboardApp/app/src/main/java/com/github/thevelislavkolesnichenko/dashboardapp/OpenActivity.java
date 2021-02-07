package com.github.thevelislavkolesnichenko.dashboardapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

public class OpenActivity implements View.OnClickListener {

    private Class activity;

    public OpenActivity(Class activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Context context = v.getContext();
        context.startActivity(new Intent(context, activity));
    }
}
