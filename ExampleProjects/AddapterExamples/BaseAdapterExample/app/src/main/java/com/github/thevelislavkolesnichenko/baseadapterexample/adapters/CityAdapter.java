package com.github.thevelislavkolesnichenko.baseadapterexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.github.thevelislavkolesnichenko.baseadapterexample.R;
import com.github.thevelislavkolesnichenko.baseadapterexample.models.City;

import java.util.ArrayList;

public class CityAdapter extends BaseAdapter {
    private Context context; //контекст в който ще се използва адаптера
    private ArrayList<City> items; //колекция с данните в адаптера

    //Конструктор за създаване на обект от класа със сетване на променливите в класа
    public CityAdapter(Context context, ArrayList<City> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //връщане броя на елементите в масива
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //връща елемент от списъка на посочената позиция
    }

    @Override
    public long getItemId(int position) {
        return position; //връща индекса на елемента от списъка
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ако липсва View обект се попълва layout за всеки елемент в списъка
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_list_view_row_items, parent, false);
        }

        // извличане на текушия елемент от списъка за показване
        City currentItem = (City) getItem(position);

        // извлича TextView за име на град и пощенски код на град
        TextView textViewItemName = convertView.findViewById(R.id.textView);
        TextView textViewItemDescription = convertView.findViewById(R.id.textView2);

        //поставя текста за има не град и пощенски код на град
        textViewItemName.setText(currentItem.getName());
        textViewItemDescription.setText(Integer.toString(currentItem.getPostCode()));

        // връща View което е изгледа на елемента в реда
        return convertView;
    }
}
