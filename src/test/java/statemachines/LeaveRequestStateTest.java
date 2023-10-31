package statemachines;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LeaveRequestStateTest {

    @Test
    void responsiblePerson() {
        LeaveRequestState leaveRequestState = LeaveRequestState.SUBMITTED;
        assertThat(leaveRequestState.responsiblePerson()).isEqualToIgnoringCase("employee");
    }
}