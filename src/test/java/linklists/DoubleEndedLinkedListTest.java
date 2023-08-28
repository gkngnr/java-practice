package linklists;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
                .map(Link::getValue)
                .get()
                .isEqualTo(newVal);
        System.out.println("linkedList after insert --> ");
        linkedList.display();
    }
}