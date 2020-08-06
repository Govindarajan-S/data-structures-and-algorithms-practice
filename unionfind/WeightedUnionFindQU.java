package unionfind;

/**
 * WeightedUnionFindQU class implements Weighted Quick Union with path compression algorithm
 * 
 * @author Govindarajan Sivaraj
 */
public class WeightedUnionFindQU {
    
    private int[] size;

    private int[] ids;

    /**
     * WeightedUnionFindQU constructor creates an initial array with values 0 to N - 1
     * where N is noOfElements given as input and size array with value 1 
     * 
     * @param noOfElements
     */
    WeightedUnionFindQU(int noOfElements) {
        size = new int[noOfElements];
        ids = new int[noOfElements];
        for (int index = 0; index < noOfElements; index++) {
            ids[index] = index;
            size[index] = 1;
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
            // Compress path of the element to root
            ids[element] = ids[ids[element]];
            element = ids[element];
        }
        return element;
    }

    /**
     * union method merges the two elements if they are from different root.
     * the element with higher node count ie larger tree is made as parent
     * and the element with lower node count ie smaller tree is made as child
     * and size of the parent node is increased with size of child node.
     * 
     * @param element1
     * @param element2
     */
    private void union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        if (pRoot == qRoot) {
            return;
        }
        if (size[pRoot] > size[qRoot]) {
            ids[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            ids[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
    }

    /**
     * connected check whether two elements are connected.
     * Two elements are connected if root of both elements are same.
     * Otherwise the two elements are not connected.
     */
    private boolean connected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    public static void main(String[] args) {
        WeightedUnionFindQU weightedQU = new WeightedUnionFindQU(10);
        weightedQU.union(4, 5);
        weightedQU.union(0, 9);
        weightedQU.union(3, 0);
        System.out.println("Is 1 and 2 connected? - " + weightedQU.connected(1, 2));
        weightedQU.union(6, 7);
        weightedQU.union(5, 6);
        weightedQU.union(1, 2);
        weightedQU.union(2, 8);
        weightedQU.union(8, 0);
        weightedQU.union(5, 2);
        System.out.println("Is 3 and 9 connected? - " + weightedQU.connected(3, 9));
        System.out.println("Resuls:");
        for (int index = 0; index < 10; index++) {
            System.out.println(weightedQU.ids[index]);
        }
        System.out.println("Size:");
        for (int index = 0; index < 10; index++) {
            System.out.println(weightedQU.size[index]);
        }
    } 
}