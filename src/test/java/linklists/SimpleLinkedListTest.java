package linklists;

import linklists.SimpleLinkedList.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleLinkedListTest {

    private SimpleLinkedList linkedList;

    @BeforeEach
    void init() {
        linkedList = new SimpleLinkedList();
        linkedList.insertHead(11);
        linkedList.insertHead(22);
        linkedList.insertHead(33);
        linkedList.insertHead(44);
    }

    @Test
    void insertHead() {
        linkedList.display();

        assertThat(linkedList.deleteHead()).isEqualTo(44);

        linkedList.display();
    }

    @Test
    void isEmpty() {
        linkedList = new SimpleLinkedList();
        assertThat(linkedList.isEmpty()).isTrue();
    }

    @Test
    void find() {
        assertThat(linkedList.find(1)).isNotPresent();

        assertThat(linkedList.find(22))
                .isPresent()
                .map(Node::getValue)
                .get()
                .isEqualTo(22);
    }

    @Test
    void reverse() {
        assertThat(linkedList.head.getValue()).isEqualTo(44);
        linkedList.display();
        linkedList.reverse();
        assertThat(linkedList.head.getValue()).isEqualTo(11);
        linkedList.display();
    }

    @ParameterizedTest
    @MethodSource
    void delete(int input, boolean hasValue) {
        System.out.println("value to be deleted: " + input);
        linkedList.display();
        final var result = linkedList.delete(input);
        linkedList.display();
        if (hasValue) {
            assertThat(result).isPresent().map(Node::getValue).get().isEqualTo(input);
        } else {
            assertThat(result).isNotPresent();
        }
        System.out.println("-----iteration-----");

    }
    private static Stream<Arguments> delete() {
        return Stream.of(
                Arguments.of(314, false),
                Arguments.of(-122, false),
                Arguments.of(11, true),
                Arguments.of(44, true),
                Arguments.of(22, true),
                Arguments.of(33, true)
        );
    }
}