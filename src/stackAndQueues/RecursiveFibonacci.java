package stackAndQueues;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n+1];
        long result = getFibonachi(n);
        System.out.println(result);
    }
    public static long getFibonachi(int n) {
        if(n < 2) {
            return 1;
        }
        if(memory[n] != 0) {
            return memory[n];
        }
        memory[n] = getFibonachi(n-1) + getFibonachi(n-2);
        return  memory[n];
    }
}
