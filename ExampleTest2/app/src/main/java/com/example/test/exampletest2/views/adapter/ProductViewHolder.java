package com.example.test.exampletest2.views.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.test.exampletest2.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    private CardView cv;
    private TextView name;
    private TextView content;
    private ImageView value;
    private ImageButton btnDelete;

    public ImageButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(ImageButton btnDelete) {
        this.btnDelete = btnDelete;
    }
    public CardView getCv() {
        return cv;
    }

    public void setCv(CardView cv) {
        this.cv = cv;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView personName) {
        this.name = personName;
    }

    public TextView getContent() {
        return content;
    }

    public void setContent(TextView personAge) {
        this.content = personAge;
    }

    public ImageView getValue() {
        return value;
    }

    public void setValue(ImageView personPhoto) {
        this.value = personPhoto;
    }

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        cv = (CardView)itemView.findViewById(R.id.cv);
        name = (TextView)itemView.findViewById(R.id.person_name);
        content = (TextView)itemView.findViewById(R.id.person_age);
        value = (ImageView)itemView.findViewById(R.id.person_photo);
        btnDelete = itemView.findViewById(R.id.btnDelete);
    }
}
