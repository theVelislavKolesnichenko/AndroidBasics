package bg.tu_varna.sit.issuapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Issue implements Parcelable {

    private final Person person;

    private final String description;
    private final String address;

    private StateType state;

    public Issue(Person person, String description, String address) {
        this.person = person;
        this.description = description;
        this.address = address;
        this.state = StateType.TODO;
    }

    protected Issue(Parcel in) {
        person = in.readParcelable(Person.class.getClassLoader());
        description = in.readString();
        address = in.readString();
        state = StateType.values()[in.readInt()];
    }

    public static final Creator<Issue> CREATOR = new Creator<Issue>() {
        @Override
        public Issue createFromParcel(Parcel in) {
            return new Issue(in);
        }

        @Override
        public Issue[] newArray(int size) {
            return new Issue[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public StateType getState() {
        return state;
    }

    public void nextState() {
        if (this.state.equals(StateType.TODO)) {
            this.state = StateType.PROGRESS;
        } else if (this.state.equals(StateType.PROGRESS)) {
            this.state = StateType.DONE;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(person, flags);
        dest.writeString(description);
        dest.writeString(address);
        dest.writeInt(state.ordinal());
    }

    @Override
    public String toString() {
        return "Issue: " +
                "\nperson: " + person +
                "\ndescription: " + description +
                "\naddress: " + address +
                "\nstate: " + state;
    }
}
