package bg.tu_varna.sit.runnableexamples.tasks;

import bg.tu_varna.sit.runnableexamples.listeners.OnResultListener;

import java.util.Random;

public class LoginSimTask implements Runnable {
    private OnResultListener listener;

    public LoginSimTask(OnResultListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        int second = new Random().nextInt(3) + 3;
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean result = new Random().nextBoolean();

        listener.OnResult(result);
    }
}
