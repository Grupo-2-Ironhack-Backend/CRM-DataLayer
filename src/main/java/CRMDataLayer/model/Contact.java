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
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_id")
    private Account account;

    public Contact(String name, String phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }
}
