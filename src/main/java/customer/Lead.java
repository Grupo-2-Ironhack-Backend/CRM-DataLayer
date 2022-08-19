package customer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.UUID;

/**
 * Definition of a Lead
 */

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
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this) + "\n" + "  ────────────────────────────";
    }
}
