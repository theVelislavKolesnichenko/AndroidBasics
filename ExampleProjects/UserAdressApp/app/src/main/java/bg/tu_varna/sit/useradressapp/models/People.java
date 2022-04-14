package bg.tu_varna.sit.useradressapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class People implements Parcelable {
    private String email;
    private String name;
    private String address;
    private String phone;

    public People(String email, String name, String address, String phone) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    protected People(Parcel in) {
        email = in.readString();
        name = in.readString();
        address = in.readString();
        phone = in.readString();
    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(phone);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Имейл: " + email);
        builder.append("\nИме: " + name);
        builder.append("\nАдрес: " + address);
        builder.append("\nТелефон: " + phone);
        return  builder.toString();
    }
}
