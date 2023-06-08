package open.code.util;

public enum DirectoryType {
    CREATION_REASON("creationReason"),
    PRESENTATION_TYPE("presentationType"),
    CHANGE_TYPE("changeType"),
    PARTICIPANT_TYPE("participantType"),
    AVAILABLE_SERVICES("availableServices"),
    EXCHANGE_PARTICIPANT("exchangeParticipant"),
    LIMITATION_SERVICES("limitationServices"),
    PARTICIPANT_STATUS("participantStatus"),
    LIMITATION_OPERATIONS("limitationOperations"),
    ACCOUNT_STATUS("accountStatus"),
    ACCOUNT_TYPE("accountType");

    private String val;

    DirectoryType(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
