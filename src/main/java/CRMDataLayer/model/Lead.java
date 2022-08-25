/**
 * Lead: it is an entity (human, most of the times)
 * that showed some interest in our product, from
 * that moment it is tracked by a Sales Representative
 * who will try to convert this lead into a win
 * opportunity (an opportunity that succesfully ended
 * in a sale).
 *
 * A lead is tracked by a sales representative, someone
 * who can track many leads, making this a 1 to many
 * relationship.
 */

package CRMDataLayer.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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

    @ManyToOne
    @JoinColumn(name="sales_rep")
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
