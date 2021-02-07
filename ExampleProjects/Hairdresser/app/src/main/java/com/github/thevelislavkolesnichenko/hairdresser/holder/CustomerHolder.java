package com.github.thevelislavkolesnichenko.hairdresser.holder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.hairdresser.R;

public class CustomerHolder extends RecyclerView.ViewHolder {
    private TextView name, type;
    private Button action;

    public CustomerHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.textView);
        type = itemView.findViewById(R.id.textView2);
        action = itemView.findViewById(R.id.button);
    }

    public String getName() {
        return name.getText().toString();
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public String getType() {
        return type.getText().toString();
    }

    public void setType(String type) {
        this.type.setText(type);
    }

    public Button getAction() {
        return action;
    }

    public void setAction(View.OnClickListener listener) {
        this.action.setOnClickListener(listener);
    }

    public void setActionVisible() {
        this.action.setVisibility(View.VISIBLE);
    }
}
