/**
 * Sales representative is a role in a company
 * who tracks every business opportunity from
 * the lead status until the opportunity is closed.
 * It is attached to the interested customer from
 * the beginning, being transferred to an opportunity
 * when a lead advances further in the sales process.
 */

package CRMDataLayer.model;

import org.springframework.lang.NonNull;
import javax.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name="sales_rep")
public class SalesRep {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name", length = 50)
    @NonNull
    private String name;

    @OneToMany(mappedBy="salesRep", cascade = CascadeType.ALL)
    private List<Lead> leads;

    @OneToMany(mappedBy="salesRep", cascade = CascadeType.ALL)
    private List<Opportunity> opportunities;

    public SalesRep(String name) {
        this.name = name;
    }

    public SalesRep() {
        super();
        leads = new ArrayList<>();
        opportunities = new ArrayList<>();
    }
}
