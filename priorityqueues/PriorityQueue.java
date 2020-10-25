package priorityqueues;

public class PriorityQueue<Key extends Comparable<Key>> {

    private Key[] keys;

    private int size;

    public PriorityQueue() {
        keys = (Key[]) new Comparable[17];
    }

    public PriorityQueue(int n) {
        keys = (Key[]) new Comparable[n + 1];
    }

    private void swim(int n) {
        while (n > 1 && less(n / 2, n)) {
            exchange(n / 2, n);
            n = n / 2;
        }
    }

    private void sink(int n) {
        while (2 * n <= size) {
            int j = 2 * n;
            if (j < size && less(j, j + 1)) {
                j++;
            }
            if (!less(n, j)) {
                break;
            }
            exchange(n, j);
            n = j;
        }
    }

    public PriorityQueue(Key[] arr) {
        keys = arr;
        size = arr.length;
        int n = size;
        while (n > 1 && less(n / 2, n)) {
            exchange(n / 2, n);
            n--;
        }
    }

    public void insert(Key key) {
        keys[++size] = key;
        swim(size - 1);
    }

    public Key getMax() {
        return keys[1];
    }

    public Key delMax() {
        Key max = keys[1];
        exchange(1, size - 1);
        keys[size - 1] = null;
        sink(1);
        return max;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    private boolean less(int pos1, int pos2) {
        return keys[pos1].compareTo(keys[pos2]) < 0;
    }

    private void exchange(int pos1, int pos2) {
        Key temp = keys[pos1];
        keys[pos1] = keys[pos2];
        keys[pos2] = temp;
    }


}
