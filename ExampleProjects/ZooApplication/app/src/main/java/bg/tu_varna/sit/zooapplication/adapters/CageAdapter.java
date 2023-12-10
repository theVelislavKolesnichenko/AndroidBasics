package bg.tu_varna.sit.zooapplication.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bg.tu_varna.sit.zooapplication.R;
import bg.tu_varna.sit.zooapplication.listeners.OnAddAnimalListener;
import bg.tu_varna.sit.zooapplication.models.Cage;
import bg.tu_varna.sit.zooapplication.views.CageViewHolder;

public class CageAdapter extends RecyclerView.Adapter<CageViewHolder> {

    private final List<Cage> cages;

    private final OnAddAnimalListener listener;

    public CageAdapter(List<Cage> cages, OnAddAnimalListener listener) {
        this.cages = cages;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CageViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cage_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CageViewHolder holder, int position) {
        Cage cage = this.cages.get(position);
        holder.setView(cage);
        holder.setOnClickListener(v -> this.listener.onAddAnimal(cage));
    }

    @Override
    public int getItemCount() {
        return cages.size();
    }

    public void addCage(Cage cage) {
        this.cages.add(cage);
        notifyItemChanged(getItemCount() - 1);
    }
}
