package trees.simple;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class BinaryTree {

    private Node head;

    @RequiredArgsConstructor
    @Getter
    static class Node {
        private final int key;
        private final double value;
        private Node right;
        private Node left;
    }

    public Node findByKey(int key) {
        if (isEmpty()) throw new EmptyTreeException("Tree is Empty, first insert item");

        var cursor = head;
        while (cursor.key != key) {
            cursor = key < cursor.key ? cursor.left : cursor.right;
            if (cursor == null) throw new KeyNotFoundException("Key cannot be found with id: " + key);
        }
        return cursor;
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

    public boolean delete(int key) {
        var current = this.head;
        var parent = this.head;
        var isLeft = true;
        while (current.key != key) {
            parent = current;
            if (key < current.key) {
                isLeft = true;
                current = current.left;
            } else {
                isLeft = false;
                current = current.right;
            }
            if (current == null)
                return false;
        }
        if (current == this.head) {
            this.head = null;
        } else if (isLeft) {
            if (isLeaf(current)) {
                parent.left = null;
            } else if (hasOnlyOneChild(current)) {
                parent.left = current.left == null ? current.right : current.left;
            }
        } else {
            if (isLeaf(current)) {
                parent.right = null;
            } else if (hasOnlyOneChild(current)) {
                parent.right = current.right == null ? current.left : current.right;
            }
        }
        return true;
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

    private boolean isLeaf(@NonNull Node node) {
        return node.right == null && node.left == null;
    }

    private boolean hasOnlyOneChild(@NonNull Node node) {
        return node.right == null ^ node.left == null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}
