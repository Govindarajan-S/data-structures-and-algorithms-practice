package problem.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Heap {

    private static class HeapPriorityQueue {
        private List<Integer> arr = new ArrayList<Integer>();

        public void insert(int value) {
            arr.add(value);
            upshift(arr.size() - 1);
        }

        public void upshift(int pos) {
            int parent;
            while (pos > 0) {
                parent = parent(pos);
                if (arr.get(pos) >= arr.get(parent)) {
                    break;
                }
                swap(pos, parent);
                pos = parent;
            }
        }

        public void delete(int value) {
            if (arr.isEmpty()) {
                return;
            }
            int j = 0;
            while (j < arr.size()) {
                if (arr.get(j) == value) {
                    break;
                }
                j++;
            }
            swap(j, arr.size() - 1);
            arr.remove(arr.size() - 1);
            downshift(j);
        }

        public void downshift(int pos) {
            while(hasLeft(pos)) {
                int lc = left(pos);
                int smallValue = lc;
                if (hasRight(pos)) {
                    int rc = right(pos);
                    if (arr.get(rc) < arr.get(lc)) {
                        smallValue = rc;
                    }
                }
                if (arr.get(pos) <= arr.get(smallValue)) {
                    break;
                }
                swap(pos, smallValue);
                pos = smallValue;
            }
        }

        private void swap(int pos1, int pos2) {
            int temp = arr.get(pos2);
            arr.set(pos2, arr.get(pos1));
            arr.set(pos1, temp);
        }

        private boolean hasLeft(int pos) {
            return left(pos) < arr.size();
        }

        private boolean hasRight(int pos) {
            return right(pos) < arr.size();
        }

        private int left(int pos) {
            return 2 * pos + 1;
        }

        private int right(int pos) {
            return 2 * pos + 2;
        }

        private int parent(int pos) {
            return (pos - 1) / 2;
        }

        private int min() {
            return arr.get(0);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int value;
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        HeapPriorityQueue hpq = new HeapPriorityQueue();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            char c = s.charAt(0);
            switch(c) {
                case '1':  value = Integer.valueOf(s.substring(2));
                            hpq.insert(value);
                            break;
                case '2': value = Integer.valueOf(s.substring(2));
                            hpq.delete(value); break;
                case '3': System.out.println(hpq.min());
            }
        }
        scanner.close();
    }
}