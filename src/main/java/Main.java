import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import customer.*;
import dbInteraction.Database;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // First we clone the repository into a new directory called db
        Database.cloneDatabase();
        // Then we execute some commands to update the database
        pruebasIO();
        // Then we push the updated database to the github repository
        Database.pushOne();
    }

    private static void pruebasIO(){
        /* Pruebas de importación / exportación de datos */

        // System.out.println("Hello world!");
        Lead lead1 = new Lead("1", "Joan", "123456789", "oscar@hola.com", "TotalTruck");
        List<Lead> leads = new ArrayList<>();

        Contact contact1 = new Contact("1", "John", "Madrid", "Spain", "");
        List<Contact> contacts = new ArrayList<>();


        Opportunity opportunity1 = new Opportunity("1", contact1, ProductType.EXAMPLE, 5, Status.EXAMPLE);
        List<Opportunity> opportunities = new ArrayList<>();


        Account account1 = new Account("1", Activity.EXAMPLE, "Madrid", "Spain", opportunities);
        List<Account> accounts = new ArrayList<>();

        // Database database = new Database();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Account> accountList = Database.loadAccountsFromDatabase();
        accounts.add(account1);
        Database.updateAccountsDatabase(accounts);
        // System.out.println(gson.toJson(database.getAccountList()));
        // System.out.println(gson.toJson(database.getContactList()));
        // System.out.println(gson.toJson(database.getLeadList()));
        // System.out.println(gson.toJson(database.getLeadList()));
        // System.out.println(database.getOpportunityList().get(1).getNumberOfTrucks());

        // leads.add(database.getLeadList().get(0));

        // System.out.println(leads);

    }

 }
