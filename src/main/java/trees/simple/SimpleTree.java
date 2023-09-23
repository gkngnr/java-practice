package trees.simple;

import lombok.NoArgsConstructor;

import java.util.Optional;


@NoArgsConstructor
public class SimpleTree {
    Node head;

    public Optional<Node> find(final int value) {
        var cursor = head;
        while (cursor != null) {
            if (value == cursor.value) {
                return Optional.of(cursor);
            }
            cursor = value > cursor.value ? cursor.right : cursor.left;
        }
        return Optional.empty();
    }

    public void insert(final int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        var cursor = head;
        while (cursor != null) {
            if (value == cursor.value)
                return;
            if (value > cursor.value) {
                if (cursor.right == null) {
                    cursor.right = new Node(value);
                    return;
                } else {
                    cursor = cursor.right;
                }
            } else {
                if (cursor.left == null) {
                    cursor.left = new Node(value);
                    return;
                } else {
                    cursor = cursor.left;
                }
            }
        }
    }


}
