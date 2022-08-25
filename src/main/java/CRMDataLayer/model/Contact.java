package CRMDataLayer.model;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

/**
 * Definition of the ContactRepository Class
 */
@Entity
@Table(name="contact")
public class Contact extends Lead{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy="decisionMaker")
    private Opportunity opportunity;
    @ManyToOne
    @JoinColumn(name="contacts")
    private Account account;

    public Contact(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }
}
