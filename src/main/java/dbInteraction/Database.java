package dbInteraction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import customer.*;
import java.util.List;

/**
 * Communication with local database
 */

public class Database {
    private List<Account> accountList;
    private List<Contact> contactList;
    private List<Lead> leadList;
    private List<Opportunity> opportunityList;
    private String dbPath = "/db";

    public Database() {
        this.accountList = DBLoader.loadAccountsFromDatabase();
        this.contactList = DBLoader.loadContactsFromDatabase();
        this.leadList = DBLoader.loadLeadsFromDatabase();
        this.opportunityList = DBLoader.loadOpportunitiesFromDatabase();
    }



    public List<Lead> getLeadList() {
        return leadList;
    }

    public void setLeadList(List<Lead> leadList) {
        this.leadList = leadList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }



    public void exportClassToJSON(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String objToJSON = gson.toJson(object);
        System.out.println(objToJSON);
    }
}
