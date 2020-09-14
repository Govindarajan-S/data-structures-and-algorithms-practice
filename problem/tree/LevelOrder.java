package problem.tree;

import java.util.LinkedList;
import java.util.Scanner;


class LevelOrder {
    
    static class Node {
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
    static LinkedList<Node> queue = new LinkedList<Node>();
	public static void levelOrder(Node root) {
        if (!(root == null)) {
            System.out.print(root.data + " ");
            queue.addLast(root.left);
            queue.addLast(root.right);
        }
        if (!queue.isEmpty()) {
            levelOrder(queue.removeFirst());
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
        levelOrder(root);
    }	
}