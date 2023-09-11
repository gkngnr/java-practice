package linklists;

import linklists.SimpleLinkedList.Node;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoubleEndedLinkedListTest {
    private DoubleEndedLinkedList linkedList;

    @BeforeEach
    void init() {
        linkedList = new DoubleEndedLinkedList();
        linkedList.insertHead(11);
        linkedList.insertHead(22);
        linkedList.insertHead(33);
        linkedList.insertHead(44);
    }

    @Test
    void insertTail() {
        final var newVal = 55;
        linkedList.insertTail(newVal);
        Assertions.assertThat(linkedList.find(newVal)).isPresent()
                .map(Node::getValue)
                .get()
                .isEqualTo(newVal);
        System.out.println("linkedList after insert --> ");
        linkedList.display();
    }

    @Test
    void merge_shouldMergeTwoListsInCorrectOrder() {
        var list1 = new DoubleEndedLinkedList();
        list1.insertTail(1);
        list1.insertTail(5);
        list1.insertTail(9);
        list1.insertTail(11);

        var list2 = new DoubleEndedLinkedList();
        list2.insertTail(2);
        list2.insertTail(3);
        list2.insertTail(10);
        list2.insertTail(12);

        list1.display();
        list2.display();

    }
}