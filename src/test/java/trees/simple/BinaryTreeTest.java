package trees.simple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree tree = new BinaryTree();

    @Test
    void insert_shouldCreateHeadIfTreeIsEmpty() {
        assertNull(tree.getHead());
        tree.insert(1, 1.1);
        assertNotNull(tree.getHead());
    }

    @Test
    void insert_shouldCreateBinaryTreeForGivenValues() {
        tree.insert(15, 155);
        tree.insert(5, 55.0);
        tree.insert(52, 553.0);
        tree.insert(25, 551.0);
        tree.insert(45, 535.0);
        tree.insert(151, 55.0);
        tree.insert(65, 55.0);
        tree.insert(651, 551.0);
        tree.insert(65, 551.0);
        tree.insert(615, 55.0);
        tree.insert(655, 55.0);
        tree.insert(23, 55.0);
        tree.insert(2, 55.0);
        tree.insert(21, 55.0);
        tree.insert(28, 55.0);
        tree.insert(7, 55.0);
        assertNotNull(tree);
        tree.traverseInOrder();
    }

}