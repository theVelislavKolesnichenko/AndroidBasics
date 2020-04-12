package com.github.thevelislavkolesnichenko.asynctaskproject.tasks;

import android.os.AsyncTask;
import androidx.fragment.app.FragmentManager;
import com.github.thevelislavkolesnichenko.asynctaskproject.LoaderFragment;
import com.github.thevelislavkolesnichenko.asynctaskproject.listener.LoaderListener;

public class LoaderAsyncTask extends AsyncTask<Integer, Integer, String> {

    private LoaderFragment loaderFragment;
    private LoaderListener loaderListener;
    private FragmentManager fm;

    public LoaderAsyncTask(FragmentManager fm, LoaderListener loaderListener) {
        this.fm = fm;
        this.loaderListener = loaderListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        loaderFragment = new LoaderFragment();
        loaderFragment.show(fm, "dialog");
    }

    @Override
    protected String doInBackground(Integer... integers) {

        int value = integers[0];
        String result = "Successful";
        for(int i=0; i<value; i++) {
            publishProgress(value - i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                result = "failed";
            }
        }

        return result;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        loaderFragment.UpdateTextView(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        loaderListener.ResultUpdate(s);
        loaderFragment.dismiss();
    }
}
