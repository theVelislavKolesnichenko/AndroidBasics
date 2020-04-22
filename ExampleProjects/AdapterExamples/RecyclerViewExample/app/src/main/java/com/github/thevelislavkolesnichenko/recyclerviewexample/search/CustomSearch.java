package com.github.thevelislavkolesnichenko.recyclerviewexample.search;

import android.widget.Filter;
import android.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomSearch implements SearchView.OnQueryTextListener {

    private Filter filter;

    public CustomSearch(Filter filter) {
        this.filter = filter;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        filter.filter(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        filter.filter(newText);
        return false;
    }
}
