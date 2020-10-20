package problem.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;


public class TreeTopView {
    
    public static class Node {
        Node left;
        Node right;
        int data;
        
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    /* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void topView(Node root) {
        if (root == null) {
            return;
        }
        SortedMap<Integer, Node> topViewMap = new TreeMap<Integer, Node>();
        LinkedList<Node> queue = new LinkedList<Node>();
        LinkedList<Integer> dQueue = new LinkedList<Integer>();
        queue.offer(root);
        dQueue.offer(0);
        Node current;
        int level, leftLevel, rightLevel;
        topViewMap.put(0, root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            level = dQueue.poll();
            if (current.left != null) {
                queue.offer(current.left);
                leftLevel = level - 1;
                dQueue.offer(leftLevel);
                if (!topViewMap.containsKey(leftLevel)) {
                    topViewMap.put(leftLevel, current.left);
                }
            }
            if (current.right != null) {
                queue.offer(current.right);
                rightLevel = level + 1;
                dQueue.offer(rightLevel);
                if (!topViewMap.containsKey(rightLevel)) {
                    topViewMap.put(rightLevel, current.right);
                }
            }
        }
        for (Map.Entry<Integer, Node> value : topViewMap.entrySet()) {
            System.out.print(value.getValue().data + " ");
        }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
