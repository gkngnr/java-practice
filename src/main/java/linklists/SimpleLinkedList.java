package linklists;

import java.util.Optional;

public class SimpleLinkedList {
    protected Link head;

    public SimpleLinkedList() {
        this.head = null;
    }

    public void insertHead(int value) {
        var newHead = new Link(value);
        newHead.setNext(this.head);
        this.head = newHead;
    }

    public int deleteHead() {
        if (!isEmpty()) {
            var oldHead = this.head.getValue();
            this.head = this.head.getNext();
            return oldHead;
        }
        return -1;
    }

    public Optional<Link> delete(final int value) {
        if (!isEmpty()) {
            var cursor = this.head;
            var previousCursor = this.head;
            while (cursor.getValue() != value) {
                if (cursor.getNext() == null) {
                    return Optional.empty();
                }
                previousCursor = cursor;
                cursor = cursor.getNext();
            }
            if (cursor == this.head) {
                this.head = this.head.getNext();
            } else {
                previousCursor.setNext(cursor.getNext());
            }
            return Optional.of(cursor);
        }
        return Optional.empty();
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public Optional<Link> find(int value) {
        if (isEmpty()) {
            return Optional.empty();
        }
        var currentItem = this.head;
        while (currentItem != null) {
            if (currentItem.getValue() == value) {
                return Optional.of(currentItem);
            }
            currentItem = currentItem.getNext();
        }

        return Optional.empty();
    }

    public void display() {
        var currentItem = this.head;
        var str = new StringBuilder("{");
        while (currentItem != null) {
            str.append(currentItem.getValue()).append(" ");
            currentItem = currentItem.getNext();
        }
        str.append("}");
        System.out.println(str);
    }

}
