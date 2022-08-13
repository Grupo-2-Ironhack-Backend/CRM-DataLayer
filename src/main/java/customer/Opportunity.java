package customer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

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

    public static List<Opportunity> loadOpportunitiesFromDatabase() {
        Opportunity[] opportunityArray;
        List<Opportunity> opportunityList;
        try {
            Reader reader = Files.newBufferedReader(Paths.get("db/opportunities.json"));
            opportunityArray = new Gson().fromJson(reader, Opportunity[].class);
            opportunityList = Arrays.asList(opportunityArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return opportunityList;
    }

    public static void updateOpportunitiesDatabase(List<Opportunity> opportunityList) {
        try {
            FileWriter writer = new FileWriter("db/opportunities.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(opportunityList));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
