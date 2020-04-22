package com.github.thevelislavkolesnichenko.runnableexample.tasks;

import android.util.Patterns;
import com.github.thevelislavkolesnichenko.runnableexample.listeners.OnValidateLoginListener;
import com.github.thevelislavkolesnichenko.runnableexample.models.User;

import java.util.regex.Pattern;

public class LoginTask implements Runnable {

    private User user;
    private OnValidateLoginListener listener;

    public LoginTask(User user, OnValidateLoginListener listener) {
        this.user = user;
        this.listener = listener;
    }

    @Override
    public void run() {

        boolean isEmail =
                user != null &&
                user.getUsername() != null &&
                !user.getUsername().isEmpty() &&
                Patterns.EMAIL_ADDRESS.matcher(user.getUsername()).matches();

        boolean isValidate =
                user != null &&
                user.getPassword() != null &&
                !user.getPassword().isEmpty() &&
                Pattern.matches(
                        "\\w{2}\\d\\w{2}\\d\\p{Upper}[!,@,#,$,%,&,\\*]\\d\\w{2}\\d\\w\\p{Upper}\\d[!,@,#,$,%,&,\\*]",
                        user.getPassword());

        listener.OnValidateLogin(isEmail && isValidate);
    }
}
