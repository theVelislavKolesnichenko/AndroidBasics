package bg.tu_varna.sit.recyclerviewexample.models;

public class Vegetables {
    private String name;
    private Double price;
    private int count;

    public Vegetables(String name, Double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Vegetables{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
