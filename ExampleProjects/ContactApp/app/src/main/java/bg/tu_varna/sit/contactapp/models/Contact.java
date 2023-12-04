package bg.tu_varna.sit.contactapp.models;

public class Contact {
    private final String name;
    private final Long phone;

    public Contact(String name, Long phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public Long getPhone() {
        return phone;
    }
}
