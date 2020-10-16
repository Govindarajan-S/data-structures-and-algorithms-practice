package problem.tree;

import java.util.Scanner;


public class BinarySearchTreeInsertion {
    
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
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

	public static Node insert(Node root,int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        Node current = root;
        Node parent = current;
        boolean left = true;
    	while (current != null) {
            if (data <= current.data) {
                parent = current;
                current = current.left;
                left = true;
            } else {
                parent = current;
                current = current.right;
                left = false;
            }
        }
        if (left) {
            parent.left = new Node(data);
        } else {
            parent.right = new Node(data);
        }
        return root;
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
      	preOrder(root);
    }	
}