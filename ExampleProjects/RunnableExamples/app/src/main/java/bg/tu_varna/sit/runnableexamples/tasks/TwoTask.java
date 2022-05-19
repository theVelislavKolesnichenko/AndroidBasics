package bg.tu_varna.sit.runnableexamples.tasks;

import bg.tu_varna.sit.runnableexamples.listeners.OnResultListener;

import java.util.Random;

public class TwoTask {

    private boolean loginResult;
    private boolean downloadResult;

    public boolean Execute() {

        LoginSimTask loginSimTask = new LoginSimTask(new OnResultListener() {
            @Override
            public void OnResult(boolean result) {
                loginResult = result;
            }
        });

        DownloadedTask downloadedTask = new DownloadedTask(new OnResultListener() {
            @Override
            public void OnResult(boolean result) {
                downloadResult = result;
            }
        });

        Thread loginn = new Thread(loginSimTask);
        Thread downloaded = new Thread(downloadedTask);

        loginn.start();
        downloaded.start();

        try {
            loginn.join();
            downloaded.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return loginResult && downloadResult;
    }
}