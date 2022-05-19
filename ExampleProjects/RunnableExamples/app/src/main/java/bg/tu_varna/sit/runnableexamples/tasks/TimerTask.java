package bg.tu_varna.sit.runnableexamples.tasks;

import bg.tu_varna.sit.runnableexamples.listeners.OnSetTimerListener;

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
