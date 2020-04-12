package com.github.thevelislavkolesnichenko.asynctaskexample.tasks;

import android.os.AsyncTask;

public class LoginAsyncTask extends AsyncTask<Integer, String, Boolean> {
    @Override
    protected Boolean doInBackground(Integer... values) {
        Boolean result = false;
        for (int i = 0; i < values[0]; i++)
        {
            try {
                Thread.sleep(1000L);
            }
            catch (Exception е) {

            }
        }
        return null;
    }
}
