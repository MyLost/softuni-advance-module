package workshop.algorithms;

import java.math.BigInteger;

public class PowRecursion {
    public static void main(String[] args) {
        int x = 100;
        int n = 22;
        System.out.println(power(x,n));
    }

    public static long power (int x, int n) {
        if(n == 1 ) {
            return 1;
        }
        return x * power(x, n-1);
    }
}
