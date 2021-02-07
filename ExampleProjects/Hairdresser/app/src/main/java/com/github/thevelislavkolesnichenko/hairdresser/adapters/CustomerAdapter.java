package com.github.thevelislavkolesnichenko.hairdresser.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.hairdresser.ActionFragmentDialog;
import com.github.thevelislavkolesnichenko.hairdresser.R;
import com.github.thevelislavkolesnichenko.hairdresser.holder.CustomerHolder;
import com.github.thevelislavkolesnichenko.hairdresser.listener.OnFragmentInteractionListener;
import com.github.thevelislavkolesnichenko.hairdresser.model.Customer;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerHolder> implements OnFragmentInteractionListener {

    private ArrayList<Customer> customers;
    private Context context;

    public CustomerAdapter(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    @NonNull
    @Override
    public CustomerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item, parent, false);

        CustomerHolder viewHolder = new CustomerHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomerHolder holder, final int position) {
        final Customer customer = customers.get(position);

        holder.setName(customer.getName());
        holder.setType(customer.getType());
        holder.setAction(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customers.remove(position);
                notifyDataSetChanged();
            }
        });
        if(customer.isState()) {
            holder.itemView.setBackgroundColor(Color.YELLOW);
            holder.setActionVisible();
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
                ActionFragmentDialog dialog = ActionFragmentDialog.newInstance(customer, position);
                dialog.show(fm, "dialog"+position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    @Override
    public void onFragmentInteraction(int position) {
        customers.get(position).setState(true);
        notifyItemChanged(position);
    }

    public void add(Customer customer) {
        customers.add(customer);
        notifyDataSetChanged();
    }

    public void remove(Customer customer) {
        customers.remove(customer);
        notifyDataSetChanged();
    }
}
