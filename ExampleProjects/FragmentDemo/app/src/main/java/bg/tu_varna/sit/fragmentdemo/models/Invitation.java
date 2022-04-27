package bg.tu_varna.sit.fragmentdemo.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Invitation implements Parcelable {
    private String name;
    private int age;
    private String message;

    public Invitation(String name, int age, String message) {
        this.name = name;
        this.age = age;
        this.message = message;
    }

    protected Invitation(Parcel in) {
        name = in.readString();
        age = in.readInt();
        message = in.readString();
    }

    public static final Creator<Invitation> CREATOR = new Creator<Invitation>() {
        @Override
        public Invitation createFromParcel(Parcel in) {
            return new Invitation(in);
        }

        @Override
        public Invitation[] newArray(int size) {
            return new Invitation[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getBurnMessage() {
        return String.format("Честит рожден ден, %s днес ставаш на %d", name, age);
    }

    public int getAge() {
        return age;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(message);
    }
}
