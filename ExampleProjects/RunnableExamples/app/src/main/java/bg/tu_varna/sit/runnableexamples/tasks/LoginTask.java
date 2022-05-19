package bg.tu_varna.sit.runnableexamples.tasks;

import android.util.Patterns;
import bg.tu_varna.sit.runnableexamples.listeners.OnValidateLoginListener;
import bg.tu_varna.sit.runnableexamples.models.User;

public class LoginTask implements Runnable {

    private String email;
    private OnValidateLoginListener listener;

    public LoginTask(String email, OnValidateLoginListener listener) {
        this.email = email;
        this.listener = listener;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean isEmail =
                email != null && !email.isEmpty() &&
                        Patterns.EMAIL_ADDRESS.matcher(email).matches();

        listener.OnValidateLogin(isEmail);
    }
}