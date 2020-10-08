package problem.tree;

import java.util.LinkedList;
import java.util.Scanner;


public class LowestCommonAncestor {
    
    public class Node {
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
	public static Node lca(Node root, int v1, int v2) {
      	// Write your code here.
        LinkedList<Node> stack1 = new LinkedList<Node>();
        LinkedList<Node> stack2 = new LinkedList<Node>();
        stack1 = getPath(root, v1);
        stack2 = getPath(root, v2);
        if (stack2.size() > stack1.size()) {
            while (stack2.size() > stack1.size()) {
                stack2.pop();
            }
        } else if (stack1.size() > stack2.size()) {
            while (stack1.size() > stack2.size()) {
                stack1.pop();
            }
        }
        while (stack1.peek() != stack2.peek()) {
            stack1.pop();
            stack2.pop();
        }
        return stack1.pop();
    }

    public static LinkedList<Node> getPath(Node root, int data) {
        LinkedList<Node> stack = new LinkedList<Node>();
        Node current = root;
        while (current != null) {
            stack.push(current);
            if (data == current.data) {
                break;
            } else if (data < current.data) {
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            }
        }
        return stack;
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
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}