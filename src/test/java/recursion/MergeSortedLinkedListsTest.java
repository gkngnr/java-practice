package recursion;

import linklists.DoubleEndedLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedLinkedListsTest {

    private DoubleEndedLinkedList list1;
    private DoubleEndedLinkedList list2;

    @BeforeEach
    void setUp() {
        list1 = new DoubleEndedLinkedList();
        list2 = new DoubleEndedLinkedList();
        list1.insertTail(1);
        list1.insertTail(5);
        list1.insertTail(9);
        list1.insertTail(11);

        list2.insertTail(2);
        list2.insertTail(3);
        list2.insertTail(10);
        list2.insertTail(12);

        list1.display();
        list2.display();
    }

    @Test
    void merge() {

        // TODO: implement merge assertion
    }
}