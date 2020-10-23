package sort;

public class Merge {

    private Comparable[] aux;

    public void sort(Comparable[] key) {
        aux = new Comparable[key.length];
        sort(key, 0, key.length - 1);
    }

    private void sort(Comparable[] key, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(key, low, mid);
        sort(key, mid + 1, high);
        merge(key, low, mid, high);
    }

    public void merge(Comparable[] key, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        while (k <= high) {
            aux[k] = key[k];
            k++;
        }
        k = low;
        while (k <= high) {
            if (i > mid) {
                key[k] = aux[j];
                j++;
            } else if (j > high) {
                key[k] = aux[i];
                i++;
            } else if (less(aux[i], aux[j])) {
                key[k] = aux[i];
                i++;
            } else {
                key[k] = aux[j];
                j++;
            }
            k++;
        }
    }

    public boolean less(Comparable key1, Comparable key2) {
        return key1.compareTo(key2) < 0;
    }

    public static void main(String[] args) {
        Integer[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Merge merge = new Merge();
        merge.sort(arr);
        for (Integer value : arr) {
            System.out.println(value);
        }
    }
    
}
