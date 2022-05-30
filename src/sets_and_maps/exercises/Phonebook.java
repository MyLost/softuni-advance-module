package sets_and_maps.exercises;

import java.util.*;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> phonebook = new HashMap<>();
        String name;
        String phone;
        boolean isSearchPhase = false;
        while(!"stop".equals(input)) {
            if(!input.equals("search") && !isSearchPhase) {
                String [] inputToken = input.split("-");
                name = inputToken[0];
                phone = inputToken[1];
                phonebook.put(name, phone);
            }
            if(input.equals("search")) {
                isSearchPhase = true;
            }
            if(isSearchPhase && !input.equals("search")) {
                if (phonebook.containsKey(input)) {
                    System.out.println(input + " -> " + phonebook.get(input));
                } else {
                    System.out.println(String.format("Contact %s does not exist.", input));
                }
            }
            input = scanner.next();
        }
    }
}
