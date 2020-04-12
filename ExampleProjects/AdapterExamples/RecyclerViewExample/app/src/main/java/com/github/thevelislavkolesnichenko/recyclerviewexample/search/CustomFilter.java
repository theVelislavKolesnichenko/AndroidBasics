package com.github.thevelislavkolesnichenko.recyclerviewexample.search;

import android.widget.Filter;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.recyclerviewexample.adapter.ContactAdapter;
import com.github.thevelislavkolesnichenko.recyclerviewexample.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class CustomFilter extends Filter {

    ContactAdapter adapter;
    List<Contact> contacts;
    List<Contact> filteredContacts;

    public CustomFilter(ContactAdapter adapter) {
        this.adapter = adapter;
        this.contacts = adapter.getDataSet();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        String charSequenceString = constraint.toString();
        if (charSequenceString.isEmpty()) {
            filteredContacts = contacts;
        } else {
            List<Contact> filteredList = new ArrayList<>();
            for (Contact name : contacts) {
                if (name.getName().toLowerCase().contains(charSequenceString.toLowerCase())) {
                    filteredList.add(name);
                }
                filteredContacts = filteredList;
            }

        }
        FilterResults results = new FilterResults();
        results.values = filteredContacts;
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.UpdateDataSet((List<Contact>)results.values);
    }
}
