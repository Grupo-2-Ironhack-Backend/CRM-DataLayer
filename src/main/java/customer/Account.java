package customer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.UUID;

/**
 * Definition of the Account Class
 */

public class Account {
    private UUID id;
    private Activity industry;
    private String city; // This could also be a very long string of cities
    private String country;
    private List<Opportunity> opportunities;

    public Account(Activity industry, String city, String country, List<Opportunity> opportunities) {
        this.id = UUID.randomUUID();
        this.industry = industry;
        this.city = city;
        this.country = country;
        this.opportunities = opportunities;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Activity getIndustry() {
        return industry;
    }

    public void setIndustry(Activity industry) {
        this.industry = industry;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this) + "\n" + "    ────────────────────────────";

    }
}
