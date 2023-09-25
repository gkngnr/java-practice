package trees.simple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree tree = new BinaryTree();

    @BeforeEach
    void init() {
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
        tree.insert(655, 5531.0);
        tree.insert(23, 55.0);
        tree.insert(2, 12.0);
        tree.insert(21, 55.0);
        tree.insert(28, 55.0);
        tree.insert(7, 55.0);
    }

    @Test
    void insert_shouldCreateHeadIfTreeIsEmpty() {
        final var treeLocal = new BinaryTree();
        assertNull(treeLocal.getHead());
        treeLocal.insert(1, 1.1);
        assertNotNull(treeLocal.getHead());
    }

    @Test
    void insert_shouldCreateBinaryTreeForGivenValues() {
        assertNotNull(tree);
        tree.traverseInOrder();
        System.out.println("---Now descending---");
        tree.traverseInOrder(false);
    }

    @Test
    void findMaxKey_shouldPrintMaxKeyValue() {
        assertNotNull(tree);
        tree.printMaxKey();
    }

    @Test
    void findMaxKey_shouldPrintMinKeyValue() {
        assertNotNull(tree);
        tree.printMinKey();
    }

    @Test
    void findMaxNode_shouldReturnNodeWithMaxKey() {
        Assertions.assertThat(tree.findMaxNode())
                .extracting(BinaryTree.Node::getKey, BinaryTree.Node::getValue)
                .containsExactly(655, 5531.0);
    }

    @Test
    void findMaxNode_shouldReturnNodeWithMinKey() {
        Assertions.assertThat(tree.findMinNode())
                .extracting(BinaryTree.Node::getKey, BinaryTree.Node::getValue)
                .containsExactly(2, 12.0);
    }

}