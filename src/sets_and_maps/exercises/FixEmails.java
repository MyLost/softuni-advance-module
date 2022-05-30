package sets_and_maps.exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> data = new LinkedHashMap<>();
        String input = scanner.nextLine();
        String name="";
        while(!"stop".equals(input)) {

            if(!input.contains("@")) {
                name = input;
            } else {
                if(!input.endsWith("us") && !input.endsWith("uk") && !input.endsWith("com")) {
                    data.put(name, input);
                }
            }

            input = scanner.nextLine();
        }

        for (var entry : data.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
