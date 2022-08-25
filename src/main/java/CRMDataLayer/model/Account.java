package CRMDataLayer.model;

import CRMDataLayer.enums.Activity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

/**
 * Definition of the Account Class
 */
@Entity
@Table(name="account")
public class Account {

    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name="industry")
    private Activity industry;
    @Column(name="city")
    private String city; // This could also be a very long string of cities or an enum
    @Column(name="country")
    private String country; // same as city case

    // 1 account holds n opportunities -->
    // 1 opportunity holds 1 decisionMaker -->
    // 1 account holds n decisionMaker (contact)
    @OneToMany(mappedBy="account")
    @JsonIgnore
    private List<Opportunity> opportunities;

    @OneToMany(mappedBy="account")
    @JsonIgnore
    private List<Contact> contacts;

    public Account(Activity industry, String city, String country) {
        this.industry = industry;
        this.city = city;
        this.country = country;
        this.opportunities = new ArrayList<>();
        this.contacts = new ArrayList<>();
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this) + "\n" + "    ────────────────────────────";
    }
}
