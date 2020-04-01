package com.github.thevelislavkolesnichenko.fragmentapplication.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.fragmentapplication.R;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView name;
    private TextView type;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.textView3);
        type = itemView.findViewById(R.id.textView4);
    }

    public void setImage(String url) {
       /* if(url.contains("dog")) {
            this.image.setImageResource(R.drawable.dog);
        } else {
            this.image.setImageResource(R.drawable.cat);
        }*/
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setType(String type) {
        this.type.setText(type);
    }
}
