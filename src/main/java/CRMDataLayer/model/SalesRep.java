package CRMDataLayer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="sales_rep")
public class SalesRep {
    @Id
    private Long id;
    @Column(name="name", length = 50)
    @NonNull
    private String name;

    @OneToOne
    @JoinColumn(name="salesRep")
    @JsonIgnore
    private Lead _lead;

    public SalesRep(String name) {
        this.name = name;
    }
}
