package customer;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Lead {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    public Lead(String id, String name, String phoneNumber, String email, String companyName) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
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
            leadList = Arrays.asList(leadArray);
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
