package pie.linkedlist;

public class CyclicAcyclic {

    public static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    public static boolean cyclicAcyclic(SinglyLinkedListNode head) {
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        SinglyLinkedListNode acyclic = new SinglyLinkedListNode(values[0]);
        SinglyLinkedListNode current;
        current = acyclic;
        int i = 1;
        while ( i < values.length) {
            current.next = new SinglyLinkedListNode(values[i]);
            current = current.next;
            i++;
        }
        boolean isAcyclic = cyclicAcyclic(acyclic);
        System.out.println("Is Cyclic : " + isAcyclic);
        current.next = acyclic;
        isAcyclic = cyclicAcyclic(acyclic);
        System.out.println("Is Cyclic : " + isAcyclic);
    }
}