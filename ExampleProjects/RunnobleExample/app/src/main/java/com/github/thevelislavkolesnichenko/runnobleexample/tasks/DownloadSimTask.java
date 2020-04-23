package com.github.thevelislavkolesnichenko.runnobleexample.tasks;

import com.github.thevelislavkolesnichenko.runnobleexample.listeners.OnResultListener;

import java.util.Random;

public class DownloadSimTask implements Runnable {

    private OnResultListener listener;

    public DownloadSimTask(OnResultListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        int millis = new Random().nextInt(3001)+2000;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean result = new Random().nextBoolean();
        listener.onResult(result);
    }
}
