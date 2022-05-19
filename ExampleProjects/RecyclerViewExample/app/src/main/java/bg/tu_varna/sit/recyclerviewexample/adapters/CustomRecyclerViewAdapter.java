package bg.tu_varna.sit.recyclerviewexample.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import bg.tu_varna.sit.recyclerviewexample.R;
import bg.tu_varna.sit.recyclerviewexample.models.Vegetables;
import bg.tu_varna.sit.recyclerviewexample.views.CustomViewHolder;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private ArrayList<Vegetables> vegetables;

    public CustomRecyclerViewAdapter(ArrayList<Vegetables> vegetables) {
        this.vegetables = vegetables;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Vegetables vegetables = this.vegetables.get(position);

        holder.setName(vegetables.getName());
        holder.setPrice(Double.toString(vegetables.getPrice()));
        holder.setCount(Integer.toString(vegetables.getCount()));
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), vegetables.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return vegetables.size();
    }

    public void update(ArrayList<Vegetables> generate) {
        vegetables = generate;
        notifyDataSetChanged();
    }
}
