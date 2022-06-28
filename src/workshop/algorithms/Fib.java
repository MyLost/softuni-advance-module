package workshop.algorithms;

import java.util.Scanner;

import java.util.*;

public class Fib {
    private static long counter = 0;

    public static long[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        dp = new long[n+1];

        System.out.println(fib(n));
    }

    public static long fib(int n) {
        System.out.println(++counter);
        if(n <= 2) {
            return 1;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fib(n-1) + fib(n-2);
    }
}
