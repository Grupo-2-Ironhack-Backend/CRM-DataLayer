package CRMDataLayer.model;

import javax.persistence.OneToMany;

public class Opportunities {

    @OneToMany
    private Opportunity opportunityId;
}
