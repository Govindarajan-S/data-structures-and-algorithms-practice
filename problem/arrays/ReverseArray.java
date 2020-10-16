package problem.arrays;

public class ReverseArray {
    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
        int midPos = a.length % 2 == 0 ? a.length / 2 : a.length / 2 + 1;
        int arrLength = a.length - 1;
        int temp;
        for (int i = 0; i < midPos; i++) {
            temp = a[i];
            a[i] = a[arrLength - i];
            a[arrLength - i] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3 ,2};
        int[] res = reverseArray(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(" " + res[i]);
        }
    }
}    