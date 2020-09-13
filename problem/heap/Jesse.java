package problem.heap;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Jesse {

private static class HeapPriorityQueue implements Iterable<Integer> {
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

        @Override
        public Iterator<Integer> iterator() {
            return arr.iterator();
        }

        private int size() {
            return arr.size();
        }
    }

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        /*
         * Write your code here.
         */
        int n = A.length;
        int sweetness = 0;
        int moves = 0;
        HeapPriorityQueue heap = new HeapPriorityQueue();
        for (int i = 0; i < n; i++) {
            heap.insert(A[i]);
        }
        boolean isPossible = true;
        if (heap.min() >= k) {
            return moves;
        }
        while(heap.min() < k) {
            if (heap.size() == 1) {
                isPossible = false;
                break;
            }
            sweetness = heap.min() * 1;
            heap.delete(heap.min());
            sweetness = sweetness + heap.min() * 2;
            heap.delete(heap.min());
            heap.insert(sweetness);
            moves++;
        }
        if (isPossible) {
            return moves;
        } else {
            return -1;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
