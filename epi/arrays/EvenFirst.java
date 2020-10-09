package epi.arrays;

public class EvenFirst {
    public static int[] evenFirstWithNoAdditionalSpace(int[] arr) {
        int i = 0;
        int n = arr.length;
        for (int j = 0; j < n; j++) {
            if (arr[j] % 2 == 0 && i != j) {
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
                i++;
            } else if (arr[j] % 2 == 0 && i == j) {
                i++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        testEvenFirstMixedValues();
        testEvenFirstOddValues();
        testEvenFirstEvenValues();
    }

    public static void testEvenFirstMixedValues() {
        int[] arr = {1, 2, 3, 4, 5};
        arr = evenFirstWithNoAdditionalSpace(arr);
        System.out.println("Test Even First Mixed Value: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void testEvenFirstOddValues() {
        int[] arr = {1, 3, 5, 7, 9};
        arr = evenFirstWithNoAdditionalSpace(arr);
        System.out.println("Test Even First Odd Value: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void testEvenFirstEvenValues() {
        int[] arr = {2, 4, 6, 8, 10};
        arr = evenFirstWithNoAdditionalSpace(arr);
        System.out.println("Test Even First Even Value: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
    }
}
