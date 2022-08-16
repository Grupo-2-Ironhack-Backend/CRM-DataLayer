package dbInteraction;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import customer.Account;
import customer.Contact;
import customer.Lead;
import customer.Opportunity;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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


    public static List<Account> loadAccountsFromDatabase() {
        Account[] accountArray;
        List<Account> accountList = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get("db/accounts.json"));
            accountArray = new Gson().fromJson(reader, Account[].class);
            accountList = new ArrayList<>(Arrays.asList(accountArray));
        } catch (IOException e) {
            // throw new RuntimeException(e);
            System.err.println("Error loading accounts from database. No accounts found.");
        }
        return accountList;
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

    public static List<Contact> loadContactsFromDatabase() {
        Contact[] contactArray;
        List<Contact> contactList = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get("db/contacts.json"));
            contactArray = new Gson().fromJson(reader, Contact[].class);
            contactList = Arrays.asList(contactArray);
        } catch (IOException e) {
            // throw new RuntimeException(e);
            System.err.println("Error loading contacts from database. No contacts found.");
        }
        return contactList;
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

    public static List<Lead> loadLeadsFromDatabase() {
        Lead[] leadArray;
        List<Lead> leadList = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get("db/leads.json"));
            leadArray = new Gson().fromJson(reader, Lead[].class);
            leadList = Arrays.asList(leadArray);
        } catch (IOException e) {
            // throw new RuntimeException(e);
            System.err.println("Error loading leads from database. No leads found.");
        }
        return leadList;
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

    public static List<Opportunity> loadOpportunitiesFromDatabase() {
        Opportunity[] opportunityArray;
        List<Opportunity> opportunityList = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get("db/opportunities.json"));
            opportunityArray = new Gson().fromJson(reader, Opportunity[].class);
            opportunityList = Arrays.asList(opportunityArray);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.err.println("Error loading opportunities from database. No opportunities found.");
        }
        return opportunityList;
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

    public static void cloneDatabase() {
        try {
            // Method 1 for accessing repository: Environment variables (Best Practices)
            //String envUri = System.getenv("JAVA_APP_URI");
            //Git.cloneRepository()
            //        .setURI(envUri)
            //        .setDirectory(new File(Paths.get("").toAbsolutePath().toString() + "/db"))
            //        .call();

            // Method 2 for accessing repository: Configuration File (Easier)
            String cfgUri = PropertyFileReader.getPropValues().get("JAVA_APP_URI");
            Git.cloneRepository()
                    .setURI(cfgUri)
                    .setDirectory(new File(Paths.get("").toAbsolutePath().toString() + "/db"))
                    .call();
        } catch (GitAPIException e) {
            // e.printStackTrace(); // We don't want to fail the program if the clone fails.
            System.err.println("Failed to clone the database, but still continuing.");
        } catch (IOException e) {
            System.err.println("Failed to clone the database, but still continuing.");
            //throw new RuntimeException(e);
        }
    }

    public static void pushOne(){
        try {
            // Method 1 for providing credentials: Environment variables (Best Practices)
            // String envUsername = System.getenv("JAVA_APP_USERNAME");
            // String envAccessToken = System.getenv("JAVA_APP_PASSWORD");
            // UsernamePasswordCredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider(envUsername, envAccessToken);

            // Method 2 for providing credentials: Configuration File (Easier)
            String cfgUsername = PropertyFileReader.getPropValues().get("JAVA_APP_USERNAME");
            String cfgAccessToken = PropertyFileReader.getPropValues().get("JAVA_APP_PASSWORD");
            UsernamePasswordCredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider(cfgUsername, cfgAccessToken);

            Git git = Git.open(new File(Paths.get("").toAbsolutePath().toString() + "/db"));
            git.add().addFilepattern(".").call();
            git.commit().setMessage("Auto-update").call();
            PushCommand command = git.push().setForce(true);
            command.setCredentialsProvider(credentialsProvider);
            command.call();
        } catch (IOException | GitAPIException e ) {
            e.printStackTrace(); // We don't want to fail the program if the push fails
            System.err.println("Error pushing to remote repository, but still updating local database.");
        }
    }

}
