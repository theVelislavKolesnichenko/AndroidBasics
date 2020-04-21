package com.github.thevelislavkolesnichenko.runnableexample.tasks;

import com.github.thevelislavkolesnichenko.runnableexample.listeners.OnSetTimerListener;

public class TimerTask implements Runnable {

    private OnSetTimerListener listener;

    public TimerTask(OnSetTimerListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        listener.OnSetTimer(1);
    }
}
