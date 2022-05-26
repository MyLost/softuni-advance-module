package sets_and_maps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> regularGuests = new TreeSet<>();
        Set<String> vipGuests = new TreeSet<>();
        Set<String> guests = new TreeSet<>();
        String input = scanner.nextLine();

        while(true) {
            if(input.equals("PARTY")) {
                while(!"END".equals(input)) {
                    guests.remove(input);
                    input = scanner.nextLine();
                }
                break;
            } else {
                guests.add(input);
            }
             input = scanner.nextLine();
        }
        System.out.println(guests.size());
        guests.forEach(guest -> {
            if(Character.isDigit(guest.charAt(0))){
                vipGuests.add(guest);
            } else {
                regularGuests.add(guest);
            }
        });
        vipGuests.forEach(System.out::println);
        regularGuests.forEach(System.out::println);
    }
}
