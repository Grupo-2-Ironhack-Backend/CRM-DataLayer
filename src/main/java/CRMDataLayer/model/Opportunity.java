/**
 * An opportunity represents an specific interest
 * from a lead in one of our products. From the moment
 * a lead shows an specific interest it is
 * converted to a contact and attached to the
 * opportunity, a sales representative who
 * was attached to the preceeding lead is attached
 * too.
 */
package CRMDataLayer.model;

import CRMDataLayer.enums.ProductType;
import CRMDataLayer.enums.Status;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="opportunity")
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="product_type")
    @NonNull
    private ProductType productType;
    @Column(name="quantity")
    private int numberOfTrucks;
    @Column(name="status")
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="opportunity")
    private Contact decisionMaker;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sales_representative")
    private SalesRep salesRep;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="opportunities")
    private Account account;

    public Opportunity(ProductType productType, int numberOfTrucks, Status status, SalesRep salesRep) {
        this.productType = productType;
        this.numberOfTrucks = numberOfTrucks;
        this.status = status;
        this.salesRep = salesRep;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this) + "\n" + "   ────────────────────────────";
    }
}
