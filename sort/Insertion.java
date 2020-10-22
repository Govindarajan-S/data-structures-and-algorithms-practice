package sort;

public class Insertion {

    public void sort(Comparable[] key) {
        int n = key.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(key[j], key[j - 1])) {
                    exchange(key, j , j - 1);
                }
            }
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
        Insertion ins = new Insertion();
        ins.sort(arr);
        for (Integer value : arr) {
            System.out.println(value);
        }
    }
}
