package stackAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> stack = new ArrayDeque<>();

        String nextnavigation = scanner.nextLine();
        String currentUrl = "blank";
        while (!"Home".equals(nextnavigation)) {
            if(nextnavigation.equals("back")) {
                if(!stack.isEmpty()){
                    currentUrl=stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    nextnavigation = scanner.nextLine();
                    continue;
                }
            } else {
                if(!currentUrl.equals("blank")) {
                    stack.push(currentUrl);
                }
                currentUrl = nextnavigation;
            }
            System.out.println(currentUrl);
            nextnavigation = scanner.nextLine();
        }
    }
}
