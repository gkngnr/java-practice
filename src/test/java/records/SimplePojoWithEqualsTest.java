package records;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimplePojoWithEqualsTest {

    @Test
    void equalsShouldReturnTrue() {
        final var pojo1 = new SimplePojoWithEquals(12, "bla");
        final var pojo2 = new SimplePojoWithEquals(12, "bla");

        assertThat(pojo1.getAge()).isEqualTo(pojo2.getAge());
        assertThat(pojo1.getName()).isEqualTo(pojo2.getName());

        assertThat(pojo1).isEqualTo(pojo2);
    }

}