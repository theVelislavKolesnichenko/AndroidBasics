package bg.tu_varna.sit.recyclerviewexample.models;

public class Fruit extends Vegetables {
    private int index;

    public Fruit(String name, Double price, int count, int index) {
        super(name, price, count);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Fruit{" +
                "index=" + index +
                '}';
    }
}
