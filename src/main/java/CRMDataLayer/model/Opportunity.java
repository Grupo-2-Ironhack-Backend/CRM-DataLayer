/**
 * An opportunity represents a specific interest
 * from a lead in one of our products. From the moment
 * a lead shows a specific interest it is
 * converted to a contact and attached to the
 * opportunity, a sales representative who
 * was attached to the preceding lead is attached
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="opportunity")
    private Contact decisionMaker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sales_representative")
    private SalesRep salesRep;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="opportunities")
    private Account account;

    public Opportunity(ProductType productType, int numberOfTrucks, Status status) {
        this.productType = productType;
        this.numberOfTrucks = numberOfTrucks;
        this.status = status;
    }
}
