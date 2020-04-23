package com.github.thevelislavkolesnichenko.runnobleexample.tasks;

import com.github.thevelislavkolesnichenko.runnobleexample.listeners.OnResultListener;
import com.github.thevelislavkolesnichenko.runnobleexample.listeners.OnValidateLoginListener;

public class TwоRunnableTask {

    boolean resultLogin, resultDW;

    public boolean execute() {

        DownloadSimTask downloadSimTask = new DownloadSimTask(new OnResultListener() {
            @Override
            public void onResult(boolean value) {
                resultDW = value;
            }
        });

        LoginSimTask loginSimTask = new LoginSimTask(new OnResultListener() {
            @Override
            public void onResult(boolean value) {
                resultLogin = value;
            }
        });

        Thread thread1 = new Thread(downloadSimTask);
        Thread thread2 = new Thread(loginSimTask);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // T && T -> V
        // T && F -> I
        // F && T -> I
        // F && F -> I

        return resultDW && resultLogin;
    }
}
