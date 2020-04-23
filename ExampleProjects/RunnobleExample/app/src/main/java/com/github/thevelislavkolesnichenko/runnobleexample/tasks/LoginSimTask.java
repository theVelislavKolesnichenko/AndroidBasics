package com.github.thevelislavkolesnichenko.runnobleexample.tasks;

import com.github.thevelislavkolesnichenko.runnobleexample.listeners.OnResultListener;

import java.util.Random;

public class LoginSimTask implements Runnable {

    private OnResultListener listener;

    public LoginSimTask(OnResultListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        int millis = new Random().nextInt(2001)+3000;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean result = new Random().nextBoolean();
        listener.onResult(result);
    }
}