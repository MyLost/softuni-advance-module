package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if(data.size() < capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
//        return data.removeIf(egg -> egg.getColor() == color);
        Egg egg = this.getEgg(color);
        data.remove(egg);
        return egg != null;
    }

    public Egg getStrongestEgg() {
//        Egg egg = null;
//        for (Egg item : data) {
//            if(egg == null) {
//                egg = item;
//            } else {
//                if(item.getStrength() > egg.getStrength()) {
//                    egg = item;
//                }
//            }
//        }
//        return egg;
        return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {
        return data.stream().filter(egg -> egg.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
//        StringBuilder builder = new StringBuilder();
//        builder.append(String.format("%s basket contains: " + System.lineSeparator(), material));
//        data.stream().forEach(egg -> builder.append(egg.toString() + System.lineSeparator()));
//        return builder.toString().trim();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:%n",material));

        data.forEach(egg -> sb.append(egg.toString()).append(String.format("%n")));

        return sb.toString().trim();
    }

}
