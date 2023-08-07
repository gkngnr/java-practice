package records;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleRecordTest {

    @Test
    void equalsShouldReturnTrue() {
        final var record1 = new SimpleRecord(11, "gidi");
        final var record2 = new SimpleRecord(11, "gidi");

        assertThat(record1.age()).isEqualTo(record2.age());
        assertThat(record1.name()).isEqualTo(record2.name());
        assertThat(record1).isEqualTo(record2);

    }

    @Test
    void equalsShouldReturnFalse() {
        final var record1 = new SimpleRecord(11, "gidi");
        final var record2 = new SimpleRecord(11, "gidix");

        assertThat(record1.age()).isEqualTo(record2.age());
        assertThat(record1.name()).isNotEqualTo(record2.name());
        assertThat(record1).isNotEqualTo(record2);

    }

}