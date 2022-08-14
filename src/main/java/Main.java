import customer.*;
import dbInteraction.Database;
import ui.MainMenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //pruebasIO(); //Debería imprimir las arrays en formato JSON
        MainMenu menu = new MainMenu();
        menu.executeCommand();
    }

    private static void pruebasIO(){
        /* Pruebas de importación / exportación de datos */

        System.out.println("Hello world!");
        Lead lead1 = new Lead("Joan", "123456789", "oscar@hola.com", "TotalTruck");
        Lead lead2 = new Lead("Marc", "9876543", "1@1.es", "TotalTruck");
        Lead lead3 = new Lead("Juan", "9876543", "2@2.es", "TotalTruck");
        List<Lead> leads = new ArrayList<>();
        leads.add(lead1);
        leads.add(lead2);
        leads.add(lead3);
        Lead.updateLeadsDatabase(leads);


        Contact contact1 = new Contact("IT", "Madrid", "Spain", "");
        Contact contact2 = new Contact("IT", "Madrid", "Spain", "");
        Contact contact3 = new Contact("IT", "Madrid", "Spain", "");
        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        Contact.updateContactsDatabase(contacts);

        Opportunity opportunity1 = new Opportunity(contact1, ProductType.EXAMPLE, 5, Status.EXAMPLE);
        Opportunity opportunity2 = new Opportunity(contact2, ProductType.EXAMPLE, 20, Status.EXAMPLE);
        Opportunity opportunity3 = new Opportunity(contact3, ProductType.EXAMPLE, 50, Status.EXAMPLE);
        List<Opportunity> opportunities = new ArrayList<>();
        opportunities.add(opportunity1);
        opportunities.add(opportunity2);
        opportunities.add(opportunity3);
        Opportunity.updateOpportunitiesDatabase(opportunities);


        Account account1 = new Account(Activity.EXAMPLE, "Madrid", "Spain", opportunities);
        Account account2 = new Account(Activity.EXAMPLE, "Madrid", "Spain", opportunities);
        Account account3 = new Account(Activity.EXAMPLE, "Madrid", "Spain", opportunities);
        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        Account.updateAccountsDatabase(accounts);


        Database database = new Database();
        System.out.println(database.getAccountList());
        System.out.println(database.getContactList());
        System.out.println(database.getLeadList());
        System.out.println(database.getOpportunityList());
        System.out.println(database.getOpportunityList().get(1).getNumberOfTrucks());

        Database db = new Database();
        System.out.println("Jelou");
        db.exportClassToJSON(db);
    }

 }
