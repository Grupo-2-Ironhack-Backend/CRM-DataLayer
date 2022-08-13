package customer;



public class Opportunity {
    private String id;
    private Contact decisionMaker;
    private ProductType porductType;
    private int numberOfTrucks;
    private Status status;

    public Opportunity(String id, Contact decisionMaker, ProductType porductType, int numberOfTrucks, Status status) {
        this.id = id;
        this.decisionMaker = decisionMaker;
        this.porductType = porductType;
        this.numberOfTrucks = numberOfTrucks;
        this.status = status;
    }

    public int getNumberOfTrucks() {
        return numberOfTrucks;
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "id=" + id +
                ", decisionMaker=" + decisionMaker +
                ", porductType=" + porductType +
                ", numberOfTrucks=" + numberOfTrucks +
                ", status=" + status +
                '}';
    }



}
