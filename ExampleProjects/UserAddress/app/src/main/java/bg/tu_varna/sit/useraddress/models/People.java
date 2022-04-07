package bg.tu_varna.sit.useraddress.models;

import android.os.Parcel;
import android.os.Parcelable;

public class People implements Parcelable {
    public static People EMPTY = new People("",0,"","");
    private String name;
    private int age;
    private String street;
    private String city;

    public People(String name, int age, String street, String city) {
        this.name = name;
        this.age = age;
        this.street = street;
        this.city = city;
    }

    protected People(Parcel in) {
        name = in.readString();
        age = in.readInt();
        street = in.readString();
        city = in.readString();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(street);
        dest.writeString(city);
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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "People{" +
                "\nname='" + name + '\'' +
                "\n, age=" + age +
                "\n, street='" + street + '\'' +
                "\n, city='" + city + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
