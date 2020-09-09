package problem.sorting;

public class MergeSort {
    private int[] aux;

    public void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = i; k <= high; k++) {
            aux[k] = arr[k];
        }
        for (int k = i; k <= high; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > high) {
                arr[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 10, 1, 9, 8, 26, 32, 40, 32, 40, 16};
        System.out.println("Values before Merge sort: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        MergeSort ms = new MergeSort();
        ms.sort(arr);
        System.out.println("\nValues after Merge sort: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }
}
