import lesson1.Box;
import lesson1.Candy;
import lesson1.Chocolate;
import lesson1.Cookie;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Candy bonbon = new Candy("БонПари",35.50, 80, "tropic mix");
        Cookie cookie = new Cookie("Cookie-pookie", 51, 120,"sponge cookie");
        Chocolate chocolate = new Chocolate("Choco-loco", 89, 50, 70);
        Candy bonbons = new Candy("Skittles", 43.40, 20, "forest fruits");

        Box box = new Box(new ArrayList<>());

        box.add(bonbon);
        box.add(chocolate);
        box.deleteLast();
        box.add(bonbons);
        box.add(cookie);
        box.add(chocolate);
        box.deleteByIndex(2);
        box.getInfo();
        box.showWeight();
        box.showPrice();


    }
}