package bg.tu_varna.sit.zooapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Cage implements Parcelable {

    private static int ID = 0;
    private CageType type;
    private Set<Animal> animals;

    public Cage(CageType type) {
        ID++;
        this.type = type;
        this.animals = new HashSet<>();
    }

    protected Cage(Parcel in) {
        ID = in.readInt();
        this.type = CageType.values()[in.readInt()];
        this.animals = (Set<Animal>) in.readValue(Set.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeInt(this.type.ordinal());
        dest.writeValue(this.animals);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Cage> CREATOR = new Creator<Cage>() {
        @Override
        public Cage createFromParcel(Parcel in) {
            return new Cage(in);
        }

        @Override
        public Cage[] newArray(int size) {
            return new Cage[size];
        }
    };

    public int getId() {
        return ID;
    }

    public CageType getType() {
        return type;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }
}
