package trees.simple;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree tree = new BinaryTree();

    @BeforeEach
    void init() {
        tree.insert(15, 155.0);
        tree.insert(5, 55.0);
        tree.insert(52, 525.0);
        tree.insert(25, 255.0);
        tree.insert(45, 455.0);
        tree.insert(151, 1515.0);
        tree.insert(65, 655.0);
        tree.insert(651, 6515.0);
        tree.insert(645, 6455.0);
        tree.insert(615, 6155.0);
        tree.insert(655, 6555.0);
        tree.insert(23, 235.0);
        tree.insert(2, 25.0);
        tree.insert(21, 215.0);
        tree.insert(28, 285.0);
        tree.insert(7, 75.0);
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
        assertThat(tree.findMaxNode())
                .extracting(BinaryTree.Node::getKey, BinaryTree.Node::getValue)
                .containsExactly(655, 6555.0);
    }

    @Test
    void findMaxNode_shouldReturnNodeWithMinKey() {
        assertThat(tree.findMinNode())
                .extracting(BinaryTree.Node::getKey, BinaryTree.Node::getValue)
                .containsExactly(2, 25.0);
    }

    @Test
    void findByKey_shouldThrowEmptyTreeExceptionWhenTreeIsEmpty() {
        var emptyTree = new BinaryTree();
        assertTrue(emptyTree.isEmpty());
        assertThrows(EmptyTreeException.class, () -> emptyTree.findByKey(1));
    }
    @ParameterizedTest
    @ValueSource(ints = {7, 2, 21, 28, 615, 655, 65, 28, 23, 45, 645})
    void delete_shouldRemoveTheCorrectNode(int key) {
        assertNotNull(tree.findByKey(key));
        assertTrue(tree.delete(key));
        assertThrows(KeyNotFoundException.class , () -> tree.findByKey(key));
    }
    @Test
    void findByKey_shouldThrowKeyNotFoundExceptionIfKeyIsNotFound() {
        assertThatThrownBy(() ->  tree.findByKey(-1))
                .isInstanceOf(KeyNotFoundException.class)
                .hasMessage("Key cannot be found with id: -1");
    }

    @ParameterizedTest
    @MethodSource
    void findByKey_shouldReturnNodeHavingTheKey(int key, double val) {
        assertThat(tree.findByKey(key))
                .extracting(BinaryTree.Node::getKey, BinaryTree.Node::getValue)
                .containsExactly(key, val);
    }

    static Stream<Arguments> findByKey_shouldReturnNodeHavingTheKey() {
        return Stream.of(
                Arguments.of(5, 55.0),
                Arguments.of(7, 75.0),
                Arguments.of(23, 235.0),
                Arguments.of(45, 455.0),
                Arguments.of(52, 525.0),
                Arguments.of(65, 655.0),
                Arguments.of(151, 1515.0),
                Arguments.of(651, 6515.0),
                Arguments.of(15, 155.0)
        );
    }

    @Test
    void xorTest() {
        String str1 = "re";
        String str2 = null;
        String str3 = "gasdg";
        String str4 = null;
        assertTrue(xor(str1, str2));
        assertTrue(xor(str2, str1));
        assertFalse(xor(str1, str3));
        assertFalse(xor(str3, str1));
        assertFalse(xor(str4, str2));
        assertFalse(xor(str2, str4));
    }

    private boolean xor(String str1, String str2) {
        return str1 == null ^ str2 == null;
    }

}