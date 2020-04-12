package com.github.thevelislavkolesnichenko.asynctaskexample.tasks;

import android.os.AsyncTask;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.github.thevelislavkolesnichenko.asynctaskexample.LoaderFragment;
import com.github.thevelislavkolesnichenko.asynctaskexample.listener.LoaderListener;

public class LoaderAsyncTask extends AsyncTask<Integer, Integer, String> {

    LoaderFragment loaderFragment;
    FragmentManager fragmentManager;
    LoaderListener listener;

    public LoaderAsyncTask(FragmentManager fm, LoaderListener listener) {
        fragmentManager = fm;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        loaderFragment = LoaderFragment.newInstance(1);
        loaderFragment.show(fragmentManager, "dialog");
    }

    @Override
    protected String doInBackground(Integer... integers) {
        int value = integers[0];
        for (int i =0; i< value; i++) {
            publishProgress(value - i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "Successful";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        loaderFragment.UpdateValue(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        listener.Result(s);
        loaderFragment.dismiss();
    }
}
