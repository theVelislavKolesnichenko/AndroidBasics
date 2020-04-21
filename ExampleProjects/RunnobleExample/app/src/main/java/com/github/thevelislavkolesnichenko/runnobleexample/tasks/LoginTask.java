package com.github.thevelislavkolesnichenko.runnobleexample.tasks;

import android.app.Activity;
import android.util.Patterns;
import com.github.thevelislavkolesnichenko.runnobleexample.listeners.OnValidateLoginListener;
import com.github.thevelislavkolesnichenko.runnobleexample.models.User;

import java.util.regex.Pattern;

public class LoginTask implements Runnable {

    private OnValidateLoginListener listener;
    private User user;

    public LoginTask(OnValidateLoginListener listener, User user) {
        this.listener = listener;
        this.user = user;
    }

    @Override
    public void run() {
        boolean isValidate = user.getPassword() != null && !user.getPassword().isEmpty() &&
                Pattern.matches("\\w{2}\\d\\w{2}\\d\\p{Upper}[!,@,#,$,%,&,\\*]\\d\\w{2}\\d\\w\\p{Upper}\\d[!,@,#,$,%,&,\\*]", user.getPassword());

        boolean isEmail = user.getEmail() != null && !user.getEmail().isEmpty() &&
                Patterns.EMAIL_ADDRESS.matcher(user.getEmail()).matches();

        listener.OnValidateLogin(isValidate && isEmail);
    }
}
