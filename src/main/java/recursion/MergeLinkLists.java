package recursion;

import linklists.DoubleEndedLinkedList;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MergeLinkLists extends DoubleEndedLinkedList {

    static Node merge(Node A, Node B) {
        if (A == null) return B;
        if (B == null) return A;

        if (A.getValue() < B.getValue()) {
            A.setNext(merge(A.getNext(), B));
            return A;
        } else {
            B.setNext(merge(A, B.getNext()));
            return B;
        }
    }
}
