package bg.tu_varna.sit.contactapp.views;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import bg.tu_varna.sit.contactapp.R;
import bg.tu_varna.sit.contactapp.models.Contact;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private final TextView name;
    private final TextView phone;
    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.textView2);
        this.phone = itemView.findViewById(R.id.textView3);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public  void setPhone(Long phone) {
        this.phone.setText(String.valueOf(phone));
    }

    public void init(Contact contact) {
        this.name.setText(contact.getName());
        this.phone.setText(String.valueOf(contact.getPhone()));
    }
}
