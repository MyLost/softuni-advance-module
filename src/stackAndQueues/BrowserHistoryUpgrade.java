package stackAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> backword = new ArrayDeque<>();
        Deque<String> forword = new ArrayDeque<>();
        String nextnavigation = scanner.nextLine();
        String currentUrl = "blank";
        String forwordUrl = "blank";
        while (!"Home".equals(nextnavigation)) {
            if(nextnavigation.equals("forward")) {
                if (forwordUrl.equals("blank")) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwordUrl);
                    backword.push(currentUrl);
                    currentUrl = forwordUrl;
                    if(forword.isEmpty()) {
                        forwordUrl = "blank";
                    } else {
                        forwordUrl = forword.pop();
                    }
                }
                nextnavigation = scanner.nextLine();
                continue;
            }
                if (nextnavigation.equals("back")) {
                    if (!backword.isEmpty()) {
                        forword.push(forwordUrl);
                        forwordUrl = currentUrl;
                        currentUrl = backword.pop();
                    } else {
                        System.out.println("no previous URLs");
                        nextnavigation = scanner.nextLine();
                        continue;
                    }
                } else {
                    if (!currentUrl.equals("blank")) {
                        backword.push(currentUrl);
                    }
                    currentUrl = nextnavigation;
                    forwordUrl="blank";
                }
                System.out.println(currentUrl);
            nextnavigation = scanner.nextLine();
        }
    }
}
