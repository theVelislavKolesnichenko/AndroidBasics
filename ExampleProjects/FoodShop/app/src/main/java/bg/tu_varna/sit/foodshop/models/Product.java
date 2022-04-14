package bg.tu_varna.sit.foodshop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private String shopName;
    private String name;
    private double price;
    private int size;

    public Product(String shopName, String name, String price, String size) {
        this.shopName = shopName;
        this.name = name;
        this.price = Double.parseDouble(price);
        this.size = Integer.parseInt(size);
    }

    protected Product(Parcel in) {
        shopName = in.readString();
        name = in.readString();
        price = in.readDouble();
        size = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Продукт:");
        builder.append(name);
        builder.append("За магазин: ");
        builder.append(shopName);
        builder.append(" с цена ");
        builder.append(price);
        builder.append(" и количество ");
        builder.append(size);
        builder.append(" общо ");
        builder.append(price * size);

        return builder.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(shopName);
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeInt(size);
    }
}
