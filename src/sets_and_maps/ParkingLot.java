package sets_and_maps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> parkingLot = new LinkedHashSet<>();
        String commnd;
        String carNumber;
        while(!"END".equals(input)) {
            String[] inputTokens = input.split(",\\s+");
            commnd = inputTokens[0];
            carNumber = inputTokens[1];

            if(commnd.equals("IN")) {
                parkingLot.add(carNumber);
            }
            if(commnd.equals("OUT")) {
                parkingLot.remove(carNumber);
            }
            input = scanner.nextLine();
        }

        if(parkingLot.isEmpty()) {
            System.out.println( "Parking Lot is Empty");
        } else {
            parkingLot.forEach(System.out::println);
        }
    }
}
