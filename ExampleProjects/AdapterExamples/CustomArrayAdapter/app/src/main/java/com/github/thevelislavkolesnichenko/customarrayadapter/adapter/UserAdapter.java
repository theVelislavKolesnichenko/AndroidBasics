package com.github.thevelislavkolesnichenko.customarrayadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.thevelislavkolesnichenko.customarrayadapter.R;
import com.github.thevelislavkolesnichenko.customarrayadapter.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(@NonNull Context context, @NonNull ArrayList<User> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Извличане на текущия елемент от списъка
        User user = getItem(position);
        // проверя ва се дали съществува изглед с ресурси ако не го създава
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_item, parent, false);
        }

        // извлича елементите от изгледа
        TextView name = convertView.findViewById(R.id.username);
        TextView city = convertView.findViewById(R.id.city);
        TextView postCode = convertView.findViewById(R.id.postCode);

        // присвоява информацията от обекта User на елементите в изгледа
        name.setText(user.getName());
        city.setText(user.getCity().getName());
        postCode.setText(Integer.toString(user.getCity().getPostCode()));

        // Върнете завършения изглед за изобразяване на екрана
        return convertView;
    }
}
