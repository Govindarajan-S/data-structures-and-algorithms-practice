/**
 * UnionFindQU class implements the QuickUnion algorithm
 * 
 * @author Govindarajan Sivaraj
 */
public class UnionFindQU {

    private int ids[];

    /**
     * UnionFindQU constructor creates an initial array with values 0 to N - 1 where
     * N is noOfElements given as input
     * 
     * @param noOfElements
     */
    UnionFindQU(int noOfElements) {
        ids = new int[noOfElements];
        for (int index = 0; index < noOfElements; index++) {
            ids[index] = index;
        }
    }

    /**
     * getRoot method checks whether element points to itself.
     * If a element points to itself, then the element is the root to itself.
     * If a element does not point to itself move up the tree until the element
     * points to itself which is the root.
     * 
     * @param element
     * @return
     */
    private int getRoot(int element) {
        while (ids[element] != element) {
            element = ids[element];
        }
        return element;
    }

    /**
     * connected check whether two elements are connected.
     * Two elements are connected if root of both elements are same.
     * Otherwise the two elements are not connected.
     */
    private boolean connected(int element1, int element2) {
        return getRoot(element1) == getRoot(element2);
    }

    /**
     * union method merges the two elements if they are from different root.
     * The element1 is added as child to element2 and the parent of element1 is 
     * changed to element2.  
     * 
     * @param element1
     * @param element2
     */
    private void union(int element1, int element2) {
        int value1 = getRoot(element1);
        int value2 = getRoot(element2);
        ids[value1] = value2;
    }

    public static void main(String[] args) {
        UnionFindQU uf = new UnionFindQU(10);
        uf.union(1, 3);
        uf.union(2, 4);
        uf.union(1, 0);
        uf.union(6, 8);
        uf.union(7, 9);
        System.out.println("Is 0 and 9 connected? - " + uf.connected(0, 9));
        uf.union(2, 3);
        uf.union(5, 6);
        uf.union(5, 0);
        System.out.println("Is 3 and 8 connected? - " + uf.connected(3, 8));
        System.out.println("Results: ");
        for (int index = 0; index < uf.ids.length; index++) {
            System.out.println(uf.ids[index]);
        }
    }
}