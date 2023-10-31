package statemachines;

public enum LeaveRequestState {
    SUBMITTED {
        @Override
        public String responsiblePerson() {
            return "Employee";
        }
    },
    ESCALATED {
        @Override
        public String responsiblePerson() {
            return "Team Leader";
        }
    },
    APPROVED {
        @Override
        public String responsiblePerson() {
            return "Manager";
        }
    };


    public abstract String responsiblePerson();
}
