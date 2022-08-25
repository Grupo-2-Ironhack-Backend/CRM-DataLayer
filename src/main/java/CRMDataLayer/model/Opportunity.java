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

/**
 * Definition of Opportunity Class
 */
@Entity
@Table(name="opportunity")
public class Opportunity {
    @Id
    private Long id;
    /*@Column(name="decision_maker")
    @NonNull
    private Contact decisionMaker;*/
    @Column(name="product_type")
    @NonNull
    private ProductType productType;
    @Column(name="quantity")
    private int numberOfTrucks;
    @Column(name="status")
    private Status status;

    @OneToOne
    @JoinColumn(name="opportunity")
    private Contact decisionMaker;

    @ManyToOne
    @JoinColumn(name="opportunities")
    private Account account;

    public Opportunity(ProductType productType, int numberOfTrucks, Status status) {
        this.productType = productType;
        this.numberOfTrucks = numberOfTrucks;
        this.status = status;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this) + "\n" + "   ────────────────────────────";
    }
}
