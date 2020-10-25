package sort;

public class Heap {

    public void sort(Comparable[] keys) {
        int n = keys.length;
        int k = n / 2;
        while (k >= 1) {
            sink(keys, k , n);
            k--;
        }
        while (n > 1) {
            exchange(keys, 1, n--);
            sink(keys, 1, n);
        }
    }

    private void sink(Comparable[] keys, int pos1, int pos2) {
        while (2 * pos1 <= pos2) {
            int j = 2 * pos1;
            if (j < pos2 && less(keys, j, j + 1)) {
                j++;
            }
            if (!less(keys, pos1, j)) {
                break;
            }
            exchange(keys, pos1, j);
            pos1 = j;
        }
    }
    
    private void exchange(Comparable[] keys, int pos1, int pos2) {
        Comparable temp = keys[pos1 - 1];
        keys[pos1 - 1] = keys[pos2 - 1];
        keys[pos2 - 1] = temp;
    }

    private boolean less(Comparable[] keys, int pos1, int pos2) {
        return keys[pos1 - 1].compareTo(keys[pos2 - 1]) < 0;
    }

    public static void main(String[] args) {
        Integer[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Heap heap = new Heap();
        heap.sort(arr);
        for (Integer value : arr) {
            System.out.println(value);
        }
    }
}
