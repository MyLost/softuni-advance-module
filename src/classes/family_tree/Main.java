package classes.family_tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Person person = new Person();

        while(!"End".equals(command)) {
            String[] inputTokens = command.split(" - ");

            if(inputTokens.length == 1) {
                if(inputTokens[1].contains("[A-Z a-z]+")) {

                } else {

                }
            } else {
                if(!inputTokens[1].contains("[A-Z a-z]+")) {

                } else {

                }
            }
        }

    }
}
