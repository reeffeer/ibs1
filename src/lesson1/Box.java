package lesson1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box implements BoxInterface {

    private double totalWeight;
    private double totalPrice;

    private List<Sweets> sweetBox = new ArrayList<>();

    public Box(List<Sweets> sweetBox) {
        this.sweetBox = sweetBox;
    }

    @Override
    public void add(Sweets sweet) {
        sweetBox.add(sweet);
    }

    @Override
    public void deleteLast() {
        Iterator<Sweets> iterator = sweetBox.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            if (iterator.next().equals(sweetBox.get(sweetBox.size() - 1))) {
                iterator.remove();
            }
        }
    }

    @Override
    public void deleteByIndex(int index) {
        sweetBox.remove(index);
    }

    @Override
    public double getTotalWeight() {
        for (int i = 0; i < sweetBox.size(); i++) {
            totalWeight += sweetBox.get(i).getWeight();
        }
        return totalWeight;
    }

    @Override
    public double getTotalPrice() {
        for (Sweets s : sweetBox) {
            totalPrice += s.getPrice();
        }
        return totalPrice;
    }

    @Override
    public void showWeight() {
        System.out.println("Общий вес содержимого: " + getTotalWeight() + "g");
    }

    @Override
    public void showPrice() {
        System.out.println("Стоимость набора: " + getTotalPrice() + "rub");
    }
    @Override
    public void getInfo() {
        System.out.println("Содержимое коробки: ");
        for (Sweets s : sweetBox) {
            s.info();
        }
    }
}
