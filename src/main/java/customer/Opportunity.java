package customer;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Opportunity {
    private UUID id;
    private Contact decisionMaker;
    private ProductType productType;
    private int numberOfTrucks;

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

    private Status status;

    public Opportunity(Contact decisionMaker, ProductType productType, int numberOfTrucks, Status status) {
        this.id = UUID.randomUUID();
        this.decisionMaker = decisionMaker;
        this.productType = productType;
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
                ", porductType=" + productType +
                ", numberOfTrucks=" + numberOfTrucks +
                ", status=" + status +
                '}';
    }

    public static void updateOpportunitiesDatabase(List<Opportunity> opportunityList) {
        try {
            FileWriter writer = new FileWriter("db/opportunities.json");
            Gson gson = new Gson();
            writer.write(gson.toJson(opportunityList));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
