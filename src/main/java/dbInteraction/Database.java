package dbInteraction;

import customer.Account;
import customer.Contact;
import customer.Lead;
import customer.Opportunity;
import java.util.List;

/**
 *
 * @author Gerard
 *
 * This class is used to interact with the database.
 * It is used to load the data from the database and to update the database.
 * You can update the database by calling the updateDatabase methods. These methods are:
 * - updateAccountsDatabase(accountList)
 * - updateContactsDatabase(contactList)
 * - updateLeadsDatabase(leadList)
 * - updateOpportunitiesDatabase(opportunityList)
 *
 * You can load the data from the database by using the Database class.
 * Ex:
 *  Database database = new Database();
 *  List<Account> accountList = database.getAccountList();
 *
 *  This program should load all data from the database right after it is started and
 *  should update the database everytime we add information to a classList.
 */

public class Database {
    private List<Account> accountList;
    private List<Contact> contactList;
    private List<Lead> leadList;
    private List<Opportunity> opportunityList;

    public Database() {
        this.accountList = Account.loadAccountsFromDatabase();
        this.contactList = Contact.loadContactsFromDatabase();
        this.leadList = Lead.loadLeadsFromDatabase();
        this.opportunityList = Opportunity.loadOpportunitiesFromDatabase();
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
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

}
