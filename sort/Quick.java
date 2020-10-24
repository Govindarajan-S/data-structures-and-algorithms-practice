package sort;

import java.util.Random;

public class Quick {

    private void shuffle(Comparable[] key) {
        Random random = new Random();
        int n = key.length;
        int r;
        for (int i = 0; i < n; i++) {
            r = random.nextInt(n);
            Comparable temp = key[r];
            key[r] = key[i];
            key[i] = temp;
        }
    }

    public void sort(Comparable[] key) {
        shuffle(key);
        sort(key, 0, key.length - 1);
    }

    private void sort(Comparable[] key, int low, int high) {
        if (high <= low) {
            return;
        }
        int pivot = partition(key, low, high);
        sort(key, low, pivot);
        sort(key, pivot + 1, high);
    }

    private int partition(Comparable[] key, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable p = key[low];
        while (true) {
            while (less(key[++i], p)) {
                if (i == high) {
                    break;
                }
            }
            while (less(p, key[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(key, i, j);
        }
        exchange(key, low, j);
        return j;
    }

    private boolean less(Comparable key1, Comparable key2) {
        return key1.compareTo(key2) < 0;
    }

    private void exchange(Comparable[] key, int pos1, int pos2) {
        Comparable temp = key[pos1];
        key[pos1] = key[pos2];
        key[pos2] = temp;
    }
    
    public static void main(String[] args) {
        Integer[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Quick quick = new Quick();
        quick.sort(arr);
        for (Integer value : arr) {
            System.out.println(value);
        }
    }
}
