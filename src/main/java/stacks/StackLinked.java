package stacks;

import lombok.RequiredArgsConstructor;
import stacks.exceptions.StackEmptyException;

public class StackLinked<T> {
    private int size;
    private Node<T> top;

    @RequiredArgsConstructor
    static class Node<T> {
        private final T val;
        private Node<T> next;
        private Node<T> prev;

    }

    public StackLinked() {
        this.size = 0;
    }

    public T push(T val) {
        final var newNode = new Node<>(val);
        if (!isEmpty()) {
            top.next = newNode;
            newNode.prev = top;
        }
        top = newNode;
        size++;
        return val;
    }

    public T pop() {
        if (isEmpty()) throw new StackEmptyException("Stack is empty, an item should be pushed in order to pop!");

        final T val = top.val;
        if (top.prev != null) {
            final var prev = top.prev;
            top.prev = null;
            prev.next = null;
            top = prev;
        }
        size--;

        return val;
    }

    public T peek() {
        if (isEmpty()) throw new StackEmptyException("Stack is empty, an item should be in order to peek!");
        return top.val;
    }

    public void display() {
        if (isEmpty()) throw new StackEmptyException("Stack is empty, an item should be in order to display!");
        var item = top;
        while (item != null) {
            System.out.print(item.val + " ");
            item = item.prev;
        }
        System.out.println();
    }



    public boolean isEmpty() {
        return this.size == 0;
    }
}
