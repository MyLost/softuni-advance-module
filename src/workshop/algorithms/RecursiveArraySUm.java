package workshop.algorithms;

import java.util.*;

public class RecursiveArraySUm  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arr[] = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(sumArrayItems(arr, 0));

    }

    public static int sumArrayItems(int[] arr, int index) {
        if(index == arr.length -1) {
            return arr[index];
        }
        return arr[index] + sumArrayItems(arr, index + 1);
    }
}
