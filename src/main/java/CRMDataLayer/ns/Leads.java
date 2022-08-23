package CRMDataLayer.ns;

import CRMDataLayer.model.Lead;

import java.util.ArrayList;
import java.util.List;


/**
 * Definition of the list of Leads
 */
public class Leads {
    private List<Lead> leadList;

    public Leads() {
        leadList = new ArrayList<>();
    }

    public List<Lead> getLeadList() {
        return leadList;
    }

    public void setLeadList(List<Lead> leadList) {
        this.leadList = leadList;
    }
}
