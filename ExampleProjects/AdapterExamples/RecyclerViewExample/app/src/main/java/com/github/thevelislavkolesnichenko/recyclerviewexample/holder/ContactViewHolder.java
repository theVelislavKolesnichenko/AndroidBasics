package com.github.thevelislavkolesnichenko.recyclerviewexample.holder;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.recyclerviewexample.R;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView phone;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.textView6);
        phone = itemView.findViewById(R.id.textView7);
    }

    public TextView getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public TextView getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.setText(phone);
    }
}
