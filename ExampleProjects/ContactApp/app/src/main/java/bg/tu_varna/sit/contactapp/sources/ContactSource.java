package bg.tu_varna.sit.contactapp.sources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import bg.tu_varna.sit.contactapp.models.Contact;

public class ContactSource {
    public static List<Contact> getContacts(int count) {
        List<Contact> contacts = new ArrayList<>(count);

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            contacts.add(new Contact(
                    "Contact " + (i + 1),
                    1000000000L + random.nextLong() % 9999999999L
            ));
        }

        return contacts;
    }
}
