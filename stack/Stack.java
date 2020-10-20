package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    private Node head;

    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node oldHead = head;
            head = newNode;
            newNode.next = oldHead;
        }
        size++;
    }
    
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is Empty!");
        }
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                Item item = current.item;
                current = current.next;
                return item;
            } else {
                throw new NoSuchElementException("Stack is Empty!");
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove operation is not supported");
        }
    }

    public static void main(String[] args) {
        testPush();
        testPopWhenStackIsNotEmpty();
        testPopWhenStackIsEmpty();
        testIteratorForNoSuchElementException();
        testIteratorForUnSupportedOperationException();
    }

    public static void testPush() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        for (Integer value : stack) {
            System.out.println(value);
        }
    }

    public static void testPopWhenStackIsNotEmpty() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        stack.pop();
        for (Integer value : stack) {
            System.out.println(value);
        }
    }

    public static void testPopWhenStackIsEmpty() {
        Stack<Integer> stack = new Stack<Integer>();
        try {
            stack.pop();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testIteratorForNoSuchElementException() {
        Stack<Integer> stack = new Stack<Integer>();
        try {
            Iterator<Integer> iterator = stack.iterator();
            iterator.next();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testIteratorForUnSupportedOperationException() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        try {
            Iterator<Integer> iterator = stack.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
                iterator.remove();
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
