package statemachines;

public enum DossierStatus {
    NEW {
        @Override
        public DossierStatus getNextStatus() {
            return CHANGED;
        }
    },
    CHANGED {
        @Override
        public DossierStatus getNextStatus() {
            return REVIEWED;
        }
    },
    REVIEWED {
        @Override
        public DossierStatus getNextStatus() {
            return READY_TO_SEND;
        }
    },
    READY_TO_SEND {
        @Override
        public DossierStatus getNextStatus() {
            return SEND;
        }
    },
    SEND {
        @Override
        public DossierStatus getNextStatus() {
            return this;
        }
    };

    public abstract DossierStatus getNextStatus();
}
