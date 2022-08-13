package customer;

import java.util.ArrayList;
import java.util.List;

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
