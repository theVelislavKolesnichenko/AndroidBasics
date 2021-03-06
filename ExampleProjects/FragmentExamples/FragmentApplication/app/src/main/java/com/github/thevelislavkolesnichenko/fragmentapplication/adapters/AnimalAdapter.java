package com.github.thevelislavkolesnichenko.fragmentapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.fragmentapplication.R;
import com.github.thevelislavkolesnichenko.fragmentapplication.holders.AnimalViewHolder;
import com.github.thevelislavkolesnichenko.fragmentapplication.models.Animal;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    private ArrayList<Animal> animals;

    public AnimalAdapter(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    //for(int i = 0; i < getItemCount(); i++)
    // {
    //      holder = onCreateViewHolder();
    //      onBindViewHolder(holder, i);
    // }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View canimalView = inflater.inflate(R.layout.animal_item, parent, false);

        return new AnimalViewHolder(canimalView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {

        Animal animal = animals.get(position);

        holder.setName(animal.getName());
        holder.setType(animal.getType());
        holder.setImage(animal.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public void addAnimal(Animal animal) {
        animals.add(0, animal);
        notifyItemInserted(0);
    }
}
