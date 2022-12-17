package lesson1;

public abstract class Sweets {
    String name;
    double price;
    int weight;

    public Sweets(String name, double price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public abstract void info();
}
