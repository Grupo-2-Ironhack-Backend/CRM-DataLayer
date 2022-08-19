package customer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.UUID;

/**
 * Definition of Opportunity Class
 */

public class Opportunity {
    private UUID id;
    private Contact decisionMaker;
    private ProductType productType;
    private int numberOfTrucks;
    private Status status;

    public Opportunity(Contact decisionMaker, ProductType productType, int numberOfTrucks, Status status) {
        this.id = UUID.randomUUID();
        this.decisionMaker = decisionMaker;
        this.productType = productType;
        this.numberOfTrucks = numberOfTrucks;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setNumberOfTrucks(int numberOfTrucks) {
        this.numberOfTrucks = numberOfTrucks;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public int getNumberOfTrucks() {
        return numberOfTrucks;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this) + "\n" + "   ────────────────────────────";
    }
}
