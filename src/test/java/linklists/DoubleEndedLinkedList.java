package linklists;

import lombok.Setter;

@Setter
public class DoubleEndedLinkedList extends SimpleLinkedList {
    private Link tail;

    public DoubleEndedLinkedList() {
        super();
        this.tail = null;
    }

    @Override
    public void insertHead(int value) {
        var newHead = new Link(value);
        if (isEmpty()) {
            this.tail = newHead;
        }
        newHead.setNext(head);
        this.head = newHead;
    }

    public void insertTail(int value) {
        var newTail = new Link(value);
        if (isEmpty()) {
            this.head = newTail;
        } else {
            this.tail.setNext(newTail);
        }
        this.tail = newTail;
    }

}
