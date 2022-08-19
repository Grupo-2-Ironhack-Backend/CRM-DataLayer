package customer;

/**
 * Definition of status of an opportunity.
 */

public enum Status {
    OPEN("Open"),
    CLOSED_WON("Closed_won"),
    CLOSED_LOST("Closed_lost"),
    EXAMPLE("Example");

    public final String statusLabel;

    private Status(String statusLabel) {
        this.statusLabel = statusLabel;
    }
}
