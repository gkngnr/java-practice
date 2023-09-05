package linklists;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Optional;

public class SimpleLinkedList {

    @Getter
    @RequiredArgsConstructor
    protected static class Node {
        private final int value;
        @Setter
        private Node next;
    }

    protected Node head;

    public SimpleLinkedList() {
        this.head = null;
    }

    public void insertHead(int value) {
        var newHead = new Node(value);
        newHead.next = this.head;
        this.head = newHead;
    }

    public int deleteHead() {
        if (!isEmpty()) {
            var oldHead = this.head.value;
            this.head = this.head.next;
            return oldHead;
        }
        return -1;
    }

    public void reverse() {
        this.head = reverse(this.head);
    }

    private Node reverse(Node node) {
        if (node == null || node.next == null) return node;

        Node p = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }

    public Optional<Node> delete(final int value) {
        if (!isEmpty()) {
            var cursor = this.head;
            var previousCursor = this.head;
            while (cursor.value != value) {
                if (cursor.next == null) {
                    return Optional.empty();
                }
                previousCursor = cursor;
                cursor = cursor.next;
            }
            if (cursor == this.head) {
                this.head = this.head.next;
            } else {
                previousCursor.next = cursor.next;
            }
            return Optional.of(cursor);
        }
        return Optional.empty();
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public Optional<Node> find(int value) {
        if (isEmpty()) {
            return Optional.empty();
        }
        var currentItem = this.head;
        while (currentItem != null) {
            if (currentItem.value == value) {
                return Optional.of(currentItem);
            }
            currentItem = currentItem.next;
        }

        return Optional.empty();
    }

    public void display() {
        var currentItem = this.head;
        var str = new StringBuilder("{ ");
        while (currentItem != null) {
            str.append(currentItem.value).append(" ");
            currentItem = currentItem.next;
        }
        str.append("}");
        System.out.println(str);
    }

}
