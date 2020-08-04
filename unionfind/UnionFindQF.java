package unionfind;

/**
 * UnionFindQF class implements the Quick Find algorithm.
 * 
 * @author Govindarajan Sivaraj
 */
public class UnionFindQF {

    private int ids[];

    /**
     * UnionFindQF constructor creates an initial array with values 0 to N - 1 where
     * N is noOfElements given as input
     * 
     * @param noOfElements
     */
    public UnionFindQF(int noOfElements) {
        ids = new int[noOfElements];
        for (int index = 0; index < noOfElements; index++) {
            ids[index] = index;
        }
    }

    /**
     * connected method checks whether two values belong to the same group
     * 
     * @param p
     * @param q
     * @return
     */
    private boolean connected(int p, int q) {
        return ids[p] == ids[q];
    } 

    /**
     * union method merges two values to form a group.
     * 
     * @param p
     * @param q
     */
    private void union(int p, int q) {
        int pid = ids[p];
        int qid = ids[q];
        for (int index = 0; index < ids.length; index++) {
            if (pid == ids[index]) {
                ids[index] = qid;
            }
        }
    }

    public static void main(String[] args) {
        UnionFindQF uf = new UnionFindQF(10);
        uf.union(1, 3);
        uf.union(2, 4);
        uf.union(1, 0);
        uf.union(6, 8);
        uf.union(7, 9);
        System.out.println("Is 0 and 9 connected? - " + uf.connected(0, 9));
        uf.union(5, 6);
        uf.union(5, 0);
        System.out.println("Is 3 and 8 connected? - " + uf.connected(3, 8));
        System.out.println("Results: ");
        for (int index = 0; index < uf.ids.length; index++) {
            System.out.println(uf.ids[index]);
        }
    }
}