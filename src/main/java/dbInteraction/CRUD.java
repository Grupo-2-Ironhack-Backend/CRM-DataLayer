package dbInteraction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import customer.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Create, read, update and delete
 */
public class CRUD {

    Database db = new Database();
    private List<Lead> leadList = db.getLeadList();
    private List<Opportunity> opportunityList = db.getOpportunityList();
    private List<Contact> contactList = db.getContactList();
    private List<Account> accountList = db.getAccountList();

    public List<Lead> getLeadList() {
        return db.getLeadList();
    }

    public List<Opportunity> getOpportunityList() {
        return db.getOpportunityList();
    }

    public List<Contact> getContactList() {
        return db.getContactList();
    }

    public List<Account> getAccountList() {
        return db.getAccountList();
    }

    public Lead getLeadByID (UUID id) {
        for (Lead lead : leadList) {
            if (lead.getId().equals(id)) {
                return lead;
            }
        }
        return null;
    }

    public void removeLeadByID(UUID id) {
        Lead leadFound = getLeadByID(id);
        leadList.remove(leadFound);
    }
    public void createAndAddLead(String name, String phone, String email, String company) {
        Lead newLead = new Lead(name, phone, email, company);
        leadList.add(newLead);
    }

    public Opportunity getOpportunityByID (UUID id) {
        for (Opportunity opportunity : opportunityList) {
            if (opportunity.getId().equals(id)) {
                return opportunity;
            }
        }
        return null;
    }

    public boolean addOpportunity(Opportunity newOpportunity) {
        opportunityList.add(newOpportunity);
        return true;
    }

    public boolean addContact(Contact newContact) {
        contactList.add(newContact);
        return true;
    }

    public void createAndAddAccount(Activity industry, String city, String country) {
        Account newAccount = new Account(industry, city, country, db.getOpportunityList());
        accountList.add(newAccount);
    }

    public Opportunity convertFromLeadToOpportunity(UUID id, ProductType prodType, int truckNumber) {
        Lead leadFound = getLeadByID(id);

        Contact newContact = new Contact(leadFound.getName(), leadFound.getPhoneNumber(), leadFound.getEmail(), leadFound.getCompanyName());
        Opportunity newOpportunity = new Opportunity(newContact, prodType, truckNumber, Status.OPEN);

        addContact(newContact);
        addOpportunity(newOpportunity);

        leadList.remove(leadFound);

        return newOpportunity;
    }

    public void closeOpportunityAsLost(UUID id) {
        Opportunity opportunityFound = getOpportunityByID(id);
        opportunityFound.setStatus(Status.CLOSED_LOST);
    }

    public void closeOpportunityAsWon(UUID id) {
        Opportunity opportunityFound = getOpportunityByID(id);
        opportunityFound.setStatus(Status.CLOSED_WON);
    }
    public static void updateLeadsDatabase(List<Lead> leadList) {
        try {
            FileWriter writer = new FileWriter("db/leads.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(leadList));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateOpportunitiesDatabase(List<Opportunity> opportunityList) {
        try {
            FileWriter writer = new FileWriter("db/opportunities.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(opportunityList));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateContactsDatabase(List<Contact> contactList) {
        try {
            FileWriter writer = new FileWriter("db/contacts.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(contactList));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateAccountsDatabase(List<Account> accountList) {
        try {
            FileWriter writer = new FileWriter("db/accounts.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(accountList));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
