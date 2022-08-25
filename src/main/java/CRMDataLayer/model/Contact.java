/**
 * A contact is a lead which is being tracked in
 * the crm database. At this point, the lead has
 * showed an specific interest for a product, this
 * creates a sales opportunity, taking the lead
 * info to create the contact entity. The contact
 * and its related opportunity are stored in an
 * account.
 */

package CRMDataLayer.model;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name", length = 50)
    @NonNull
    private String name;
    @Column(name="phone")
    @NonNull
    private String phoneNumber;
    @Column(name="email")
    private String email;
    @Column(name="companyName")
    private String companyName;

    @OneToOne(mappedBy="decisionMaker", fetch = FetchType.LAZY)
    private Opportunity opportunity;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="account_id")
    private Account account;

    public Contact(String name, String phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }
}
