package CRMDataLayer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", length = 50)
    @NonNull
    private String name;

    @OneToMany(mappedBy="salesRep")
    private List<Lead> leads;

    @OneToMany(mappedBy="salesRep")
    private List<Opportunity> opportunities;

    public SalesRep(String name) {
        this.name = name;
    }

    public SalesRep() {
        super();
        leads = new ArrayList<Lead>();
        opportunities = new ArrayList<Opportunity>();
    }
}
