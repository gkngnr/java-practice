package trees.simple;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@NoArgsConstructor
public class BinaryTree {

    @Getter
    private Node head;

    @RequiredArgsConstructor
    static class Node {
        private final int key;
        private final double value;
        private Node right;
        private Node left;
    }

    public void find(int key) {
        var cursor = head;
        while (cursor != null) {
            if (cursor.key == key) {
                System.out.println("key found, value is: " + cursor.value);
                return;
            }
            cursor = cursor.key > key ? cursor.left : cursor.right;
        }
        System.out.println("Key not found");
    }

    public void insert(int key, double val) {
        final var newNode = new Node(key, val);
        if (head == null) {
            head = newNode;
            return;
        }
        var cursor = head;
        while (true) {
            if (key < cursor.key) {
                if (cursor.left == null) {
                    cursor.left = newNode;
                    return;
                }
                cursor = cursor.left;
            } else {
                if (cursor.right == null) {
                    cursor.right = newNode;
                    return;
                }
                cursor = cursor.right;
            }
        }
    }

    public void traverseInOrder() {
        traverseInOrder(this.head);
    }

    private void traverseInOrder(Node node) {
        if (node == null)
            return;
        traverseInOrder(node.left);
        System.out.println("Node key is: " + node.key);
        traverseInOrder(node.right);
    }




}
