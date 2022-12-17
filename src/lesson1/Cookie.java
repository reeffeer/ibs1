package lesson1;

public class Cookie extends Sweets {
    private String typeOfCookie;

    public Cookie(String name, double price, int weight, String typeOfCookie) {
        super(name, price, weight);
        this.typeOfCookie = typeOfCookie;
    }

    @Override
    public void info() {
        System.out.println(getClass().getSimpleName() + ": " + name + ", " + price + "rub, " + weight + "g, " + typeOfCookie);
    }
}
