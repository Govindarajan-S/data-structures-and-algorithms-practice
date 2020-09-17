package algoproblem;

import java.util.Scanner;

public class MinMaxSum {

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for ( int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        insertionSort(arr);
        int n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        System.out.print(sum - arr[n - 1] + " ");
        System.out.print(sum - arr[0]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
