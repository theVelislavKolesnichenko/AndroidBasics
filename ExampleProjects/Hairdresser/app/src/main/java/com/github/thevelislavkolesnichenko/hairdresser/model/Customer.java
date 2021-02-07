package com.github.thevelislavkolesnichenko.hairdresser.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Customer implements Parcelable {

    private String name;
    private String type;
    private boolean state;

    public Customer(String name, String type, boolean state) {
        this.name = name;
        this.type = type;
        this.state = state;
    }

    protected Customer(Parcel in) {
        name = in.readString();
        type = in.readString();
        state = in.readByte() != 0;
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean value) {
        this.state = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeByte((byte) (state ? 1 : 0));
    }
}
