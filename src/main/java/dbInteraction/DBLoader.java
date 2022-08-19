package dbInteraction;

import com.google.gson.Gson;
import customer.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Loading data from json file of the database
 */
public class DBLoader {

    public static List<Lead> loadLeadsFromDatabase() {
        Lead[] leadArray;
        List<Lead> leadList;
        try {
            Reader reader = Files.newBufferedReader(Paths.get("db/leads.json"));
            leadArray = new Gson().fromJson(reader, Lead[].class);
            leadList = new ArrayList<>(Arrays.asList(leadArray));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return leadList;
    }

    public static List<Account> loadAccountsFromDatabase() {
        Account[] accountArray;
        List<Account> accountList;

        try {
            Reader reader = Files.newBufferedReader(Paths.get("db/accounts.json"));
            accountArray = new Gson().fromJson(reader, Account[].class);
            accountList = new ArrayList<>(Arrays.asList(accountArray));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return accountList;
    }

    public static List<Contact> loadContactsFromDatabase() {
        Contact[] contactArray;
        List<Contact> contactList;

        try {
            Reader reader = Files.newBufferedReader(Paths.get("db/contacts.json"));
            contactArray = new Gson().fromJson(reader, Contact[].class);
            contactList = new ArrayList<>(Arrays.asList(contactArray));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contactList;
    }

    public static List<Opportunity> loadOpportunitiesFromDatabase() {
        Opportunity[] opportunityArray;
        List<Opportunity> opportunityList;

        try {
            Reader reader = Files.newBufferedReader(Paths.get("db/opportunities.json"));
            opportunityArray = new Gson().fromJson(reader, Opportunity[].class);
            opportunityList = new ArrayList<>(Arrays.asList(opportunityArray));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return opportunityList;
    }
}
