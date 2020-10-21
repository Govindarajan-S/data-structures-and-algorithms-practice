package sort;

public class Selection {

    public void sort(Comparable[] key) {
        int n = key.length;
        int min;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(key[j], key[min])) {
                    min = j;
                }
            }
            exchange(key, i, min);
        }
    }

    public boolean less(Comparable key1, Comparable key2) {
        return key1.compareTo(key2) < 0;
    }

    public void exchange(Comparable[] key, int pos1, int pos2) {
        Comparable temp = key[pos1];
        key[pos1] = key[pos2];
        key[pos2] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Selection sel = new Selection();
        sel.sort(arr);
        for (Integer value : arr) {
            System.out.println(value);
        }
    } 
}
