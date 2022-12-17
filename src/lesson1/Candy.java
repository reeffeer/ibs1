package lesson1;

public class Candy extends Sweets {

    private String flavour;

    public Candy(String name, double price, int weight, String flavour) {
        super(name, price, weight);
        this.flavour = flavour;
    }

    @Override
    public void info() {
        System.out.println(getClass().getSimpleName() + ": " + name + ", " + price + "rub, " + weight + "g, " + flavour);
    }
}
