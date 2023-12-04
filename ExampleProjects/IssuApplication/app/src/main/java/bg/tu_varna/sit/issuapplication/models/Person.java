package bg.tu_varna.sit.issuapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Person implements Parcelable {
    private final String name;
    private final String phone;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    protected Person(Parcel in) {
        name = in.readString();
        phone = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
    }
}
