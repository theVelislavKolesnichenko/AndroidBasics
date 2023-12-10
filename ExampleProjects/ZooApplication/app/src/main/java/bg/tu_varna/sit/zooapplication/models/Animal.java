package bg.tu_varna.sit.zooapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    private final String name;
    private final String breed;
    private final float consumption;
    private final float weight;

    public Animal(String name, String breed, float consumption, float weight) {
        this.name = name;
        this.breed = breed;
        this.consumption = consumption;
        this.weight = weight;
    }

    protected Animal(Parcel in) {
        name = in.readString();
        breed = in.readString();
        consumption = in.readFloat();
        weight = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(breed);
        dest.writeFloat(consumption);
        dest.writeFloat(weight);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public float getConsumption() {
        return consumption;
    }

    public float getWeight() {
        return weight;
    }
}
