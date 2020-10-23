package sort;

public class Shell {
    public void sort(Comparable[] key) {
        int n = key.length;
        int k = 1;
        while (k < n / 3) {
            k = 3 * k + 1;
        }
        while (k > 0) {
            int i = 0;
            while (i < k) {
                int j = i;
                while (j >= k && less(key[j], key[j - k])) {
                    exchange(key, j, j - k);
                    j -= k;
                }
                i++;
            }
            k /= 3;
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
        Shell shell = new Shell();
        shell.sort(arr);
        for (Integer value : arr) {
            System.out.println(value);
        }
    }
}