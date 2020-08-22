package problem.linkedlists;

public class InsertTailLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }

      
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    // Complete the insertNodeAtTail function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode headNode = head;
        if (headNode == null) {
            headNode = new SinglyLinkedListNode(data);
            head = headNode;
        } else {
            while (headNode.next != null) {
                headNode = headNode.next;
            }
            headNode.next = new SinglyLinkedListNode(data);
        }
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();

        for (int i = 0; i < 10; i++) {
          SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, i);
          llist.head = llist_head;
        }
        printSinglyLinkedList(llist.head);
    }
}
