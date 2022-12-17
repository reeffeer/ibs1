package lesson1;

public class Chocolate extends Sweets {

    private int cocoaContent;

    public Chocolate(String name, double price, int weight, int cocoaContent) {
        super(name, price, weight);
        this.cocoaContent = cocoaContent;
    }

    @Override
    public void info() {
        System.out.println(getClass().getSimpleName() + ": " + name + ", " + price + "rub, " + weight + "g, " + cocoaContent + "%");
    }
}
