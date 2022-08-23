package CRMDataLayer.enums;


/**
 * Definition of the Activity Class
 */
public enum Activity {
    PRODUCE("Produce"),
    ECOMMERCE("Ecommerce"),
    MANUFACTURING("Manufacturing"),
    MEDICAL("Medical"),
    OTHER("Other"),
    EXAMPLE("Example");

    public String activityLabel;

    private Activity(String activityLabel) {
        this.activityLabel = activityLabel;
    }

    @Override
    public String toString() {
        return activityLabel;
    }



}
