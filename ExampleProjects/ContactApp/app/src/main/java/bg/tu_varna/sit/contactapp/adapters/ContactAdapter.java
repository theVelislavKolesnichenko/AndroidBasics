package bg.tu_varna.sit.contactapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bg.tu_varna.sit.contactapp.R;
import bg.tu_varna.sit.contactapp.models.Contact;
import bg.tu_varna.sit.contactapp.views.ContactViewHolder;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private final List<Contact> contacts;

    public ContactAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_view, parent, false);

        ContactViewHolder viewHolder = new ContactViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);

        holder.init(contact);

//        holder.setName(contact.getName());
//        holder.setPhone(contact.getPhone());
    }

    @Override
    public int getItemCount() {
        return this.contacts.size();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        notifyDataSetChanged();
    }
}
