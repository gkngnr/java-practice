package recursion;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.NONE)
public class ReverseLinkedList {
    @Getter
    static class Node {
        private final int val;
        @Setter
        private Node next;
        public Node(int val ) {
            this.val = val;
        }
    }

    public static Node reverse(Node node) {
        if (node == null || node.next == null)
            return node;

        Node p = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }

    private static void print(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.println(temp.getVal() + " ");
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        print(n1);
        Node reversed = reverse(n1);
        System.out.println("-----");
        print(reversed);
    }
}
