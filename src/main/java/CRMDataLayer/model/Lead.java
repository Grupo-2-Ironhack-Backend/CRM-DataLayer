package CRMDataLayer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

/**
 * Definition of a Lead
 */
@Entity
@Table(name="_lead")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name", length = 50)
    private String name;
    @Column(name="phone", length=20)
    private String phoneNumber;
    @Column(name="email")
    private String email;
    @Column(name="company_name")
    private String companyName;

    @OneToOne(mappedBy="_lead")
    @JsonIgnore
    private SalesRep salesRep;

    public Lead(String name, String phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this) + "\n" + "  ────────────────────────────";
    }
}
