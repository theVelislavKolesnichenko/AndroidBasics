package bg.tu_varna.sit.zooapplication.views;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import bg.tu_varna.sit.zooapplication.R;
import bg.tu_varna.sit.zooapplication.models.Cage;

public class CageViewHolder extends RecyclerView.ViewHolder {

    private final TextView number;
    private final TextView type;
    private final TextView animalCount;

    public CageViewHolder(@NonNull View itemView) {
        super(itemView);
        number = itemView.findViewById(R.id.textView3);
        type = itemView.findViewById(R.id.textView4);
        animalCount = itemView.findViewById(R.id.textView5);
    }

    public void setView(Cage cage) {
        this.number.setText(String.valueOf(cage.getId()));
        this.type.setText(cage.getType().toString());
        this.animalCount.setText(String.valueOf(cage.getAnimals().size()));
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.itemView.setOnClickListener(listener);


    }
}
