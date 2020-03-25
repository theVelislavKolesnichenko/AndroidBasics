package com.github.thevelislavkolesnichenko.recyclerviewexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.recyclerviewexample.R;
import com.github.thevelislavkolesnichenko.recyclerviewexample.holder.ContactViewHolder;
import com.github.thevelislavkolesnichenko.recyclerviewexample.model.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<Contact> contacts;
    private Context context;

    public ContactAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.contact_item, parent, false);

        // Return a new holder instance
        ContactViewHolder viewHolder = new ContactViewHolder((contactView));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        // Get the data model based on position
        final Contact contact = contacts.get(position);

        // Set item views based on your views and data model
        holder.setName(contact.getName());
        holder.setPhone(Long.toString(contact.getNumber()));
        holder.setName(contact.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contact.getName() + ": " + contact.getNumber(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
