package bg.tu_varna.sit.birthbayinvitations.models;

import android.os.Parcel;
import android.os.Parcelable;

public class BirthdayCard implements Parcelable {
    private String name;
    private String message;
    private int age;

    public BirthdayCard(String name, String message, int age) {
        this.name = name;
        this.message = message;
        this.age = age;
    }

    protected BirthdayCard(Parcel in) {
        name = in.readString();
        message = in.readString();
        age = in.readInt();
    }

    public static final Creator<BirthdayCard> CREATOR = new Creator<BirthdayCard>() {
        @Override
        public BirthdayCard createFromParcel(Parcel in) {
            return new BirthdayCard(in);
        }

        @Override
        public BirthdayCard[] newArray(int size) {
            return new BirthdayCard[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(message);
        dest.writeInt(age);
    }
}
