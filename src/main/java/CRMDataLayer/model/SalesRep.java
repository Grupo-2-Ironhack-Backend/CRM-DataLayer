package CRMDataLayer.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class SalesRep {
    @Id
    private UUID id;
    private String name;

    @OneToMany(mappedBy = "salesRep")
    private List<Lead> leadList;

    public SalesRep() {
    }

    public SalesRep(String name, List<Lead> leadList) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.leadList = leadList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lead> getLeadList() {
        return leadList;
    }

    public void setLeadList(List<Lead> leadList) {
        this.leadList = leadList;
    }
}
