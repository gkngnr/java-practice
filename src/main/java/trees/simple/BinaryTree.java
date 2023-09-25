package trees.simple;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@NoArgsConstructor
public class BinaryTree {

    @Getter
    private Node head;

    @RequiredArgsConstructor
    @Getter
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

    public Node findMinNode() {
        return getMinNodeByKey(this.head);
    }

    private Node getMinNodeByKey(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMinNodeByKey(node.left);
    }

    public Node findMaxNode() {
        return getMaxNodeByKey(this.head);
    }

    private Node getMaxNodeByKey(Node node) {
        if (node.right == null) {
            return node;
        }
        return getMaxNodeByKey(node.right);
    }

    public void printMinKey() {
        printMinKey(this.head);
    }

    private void printMinKey(Node node) {
        if (node.left == null) {
            System.out.println("Min value is :" + node.key);
            return;
        }
        printMinKey(node.left);
    }

    public void printMaxKey() {
        printMaxKey(this.head);
    }

    private void printMaxKey(Node node) {
        if (node.right == null) {
            System.out.println("Max value is: " + node.key);
            return;
        }
        printMaxKey(node.right);
    }

    public void traverseInOrder() {
        traverseInAscendingOrder(this.head);
    }

    public void traverseInOrder(boolean isAscending) {
        if (isAscending) {
            traverseInAscendingOrder(this.head);
        } else {
            traverseInDescendingOrder(this.head);
        }
    }

    private void traverseInAscendingOrder(Node node) {
        if (node == null)
            return;
        traverseInAscendingOrder(node.left);
        System.out.println("Node key is: " + node.key);
        traverseInAscendingOrder(node.right);
    }

    private void traverseInDescendingOrder(Node node) {
        if (node == null)
            return;
        traverseInDescendingOrder(node.right);
        System.out.println("Node key is: " + node.key);
        traverseInDescendingOrder(node.left);
    }
}
