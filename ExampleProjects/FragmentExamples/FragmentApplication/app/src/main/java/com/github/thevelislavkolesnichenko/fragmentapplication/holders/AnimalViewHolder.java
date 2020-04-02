package com.github.thevelislavkolesnichenko.fragmentapplication.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.fragmentapplication.R;
import com.squareup.picasso.Picasso;

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
        Picasso.get().load(url).error(R.drawable.farm_animals_vector_cartoons).into(image);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setType(String type) {
        this.type.setText(type);
    }
}
