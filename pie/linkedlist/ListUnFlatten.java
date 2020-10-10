package pie.linkedlist;

import java.util.LinkedList;

public class ListUnFlatten {

    public static class DoublyLinkedListNode {
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;
        DoublyLinkedListNode child;
        int value;

        DoublyLinkedListNode(int data) {
            this.value = data;
        }
    }
    
    public static DoublyLinkedListNode flattenList(DoublyLinkedListNode head, DoublyLinkedListNode tail) {
        if (head == null) {
            return null;
        }
        DoublyLinkedListNode current = head;
        LinkedList<DoublyLinkedListNode> queue = new LinkedList<>();
        while (current.next != null) {
            queue.addLast(current);
            current = current.next;
        }
        queue.addLast(current);
        while (!queue.isEmpty()) {
            current = queue.removeFirst();
            if (current.child != null) {
                tail.next = current.child;
                current.child.prev = tail;
                while (tail.next != null) {
                    queue.addLast(tail);
                    tail = tail.next;
                }
                queue.addLast(tail);
            }
        }
        return head;
    }

    public static DoublyLinkedListNode listUnflatten(DoublyLinkedListNode head) {
        LinkedList<DoublyLinkedListNode> queue = new LinkedList<DoublyLinkedListNode>();
        DoublyLinkedListNode current, prev, child, tail;
        current = head;
        while (current.next != null) {
            queue.addLast(current);
            current = current.next;
        }
        queue.addLast(current);
        tail = null;
        prev = null;
        while (!queue.isEmpty()) {
            current = queue.removeFirst();
            child = current.child;
            if (child != null) {
                prev = child.prev;
                prev.next = null;
                child.prev = null;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] value = {5, 33, 17, 2, 1};
        DoublyLinkedListNode head = new DoublyLinkedListNode(value[0]);
        DoublyLinkedListNode prev = null;
        DoublyLinkedListNode current = head;
        int i = 1;
        while (i < value.length) {
            current.next = new DoublyLinkedListNode(value[i]);
            prev = current;
            current = current.next;
            current.prev = prev;
            i++;
        }
        DoublyLinkedListNode tail = current;
        int[] childValue = {6, 25, 6};
        head.child = new DoublyLinkedListNode(childValue[0]);
        current = head.child;
        i = 1;
        while (i < childValue.length) {
            current.next = new DoublyLinkedListNode(childValue[i]);
            current = current.next;
            i++;
        }
        DoublyLinkedListNode flattenedList = flattenList(head, tail);
        current = flattenedList;
        while (current.next != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println(current.value);
        current = listUnflatten(flattenedList);
        while (current.next != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println(current.value);
    }
}

