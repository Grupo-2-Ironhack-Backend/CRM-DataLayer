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


public class Lead {
    private UUID id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    public Lead(String name, String phoneNumber, String email, String companyName) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public static List<Lead> loadLeadsFromDatabase() {
        Lead[] leadArray;
        List<Lead> leadList;
        try {
            Reader reader = Files.newBufferedReader(Paths.get("db/leads.json"));
            leadArray = new Gson().fromJson(reader, Lead[].class);
            leadList = new ArrayList<>(Arrays.asList(leadArray));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return leadList;
    }
    
    public static void updateLeadsDatabase(List<Lead> leadList) {
        try {
            FileWriter writer = new FileWriter("db/leads.json");
            Gson gson = new Gson();
            writer.write(gson.toJson(leadList));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
