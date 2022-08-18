package ui;

import java.nio.file.OpenOption;
import java.util.Scanner;
import java.util.UUID;

import customer.*;
import dbInteraction.CRUD;
import dbInteraction.Database;
import dbInteraction.GitHub;

public class MainMenu {

    Scanner userInput;
    CRUD crud;

    private final String mainMenu = "\n\n================= Welcome to IronCRM =================\n" +
            "\nUse this tool to interact with your Lead database\n" +
            "and perform operations from them:\n\n" +
            "\t\"showleads\": shows a list of all leads presents in database.\n" +
            "\t\"showopportunities\": shows a list of all opportunities presents in database.\n" +
            "\t\"showcontacts\": shows a list of all contacts presents in database.\n" +
            "\t\"showaccounts\": shows a list of all accounts presents in database.\n" +
            "\t\"lookuplead\": returns an specific lead, searched by id.\n" +
            "\t\"newlead\": creates a new lead by asking for the new info.\n" +
            "\t\"removelead\": removes the lead associated with specified id.\n" +
            "\t\"convert\": converts a lead into an opportunity and creates \n" +
            "\t\t\tits associated contact and account.\n" +
            "\t\"close-lost\": changes opportunity status to \"CLOSED-LOST\" to\n" +
            "\t\t\treflect that this opportunity will not become a sale.\n" +
            "\t\"close-won\": changes opportunity status to \"CLOSED-WON\" to\n" +
            "\t\t\treflect that this opportunity will become a sale." +
            "\t\"exit\": exits the program.\n";

    private final String commandResume = "\n\n================= Cheatsheet: =================\n\n" +
            "showleads: list of leads\n" +
            "showopportunities: list of opportunities\n" +
            "showcontacts: list of contacts\n" +
            "showaccounts: list of accounts\n" +
            "lookuplead: specific lead by id\n" +
            "newlead: create a new lead\n" +
            "removelead: removes a lead\n" +
            "convert: converts a lead to an opportunity\n" +
            "close-lost: opportunity status changed to lost sale\n" +
            "close-won: opportunity status changed to won sale\n" +
            "exit: exits the program\n";

    public MainMenu() {
        userInput = new Scanner(System.in);
        crud = new CRUD();
    }

    public void executeCommand() {

        System.out.println(mainMenu);

        while (true) {
            String userCommand = userInput.nextLine();
            String command = CommandInterpreter.InputToCommand(userCommand);

            switch (command) {
                case "newlead":
                    System.out.println("\nEnter name for the new lead: ");
                    String leadName = userInput.nextLine();

                    System.out.println("\nPhone number: ");
                    String leadPhone = userInput.nextLine();

                    System.out.println("\nEmail: ");
                    String leadMail = userInput.nextLine();

                    System.out.println("\nCompany name: ");
                    String companyLead = userInput.nextLine();

                    crud.createAndAddLead(leadName, leadPhone, leadMail, companyLead);
                    System.out.println(commandResume);
                    break;

                case "removelead":
                    System.out.println("\nEnter id for the lead to remove: ");
                    String userIdLeadToRemove = userInput.nextLine();
                    String removeLeadName = crud.getLeadByID(UUID.fromString(userIdLeadToRemove)).getName();
                    crud.removeLeadByID(UUID.fromString(userIdLeadToRemove));

                    System.out.println(String.format("Lead %s removed from system.", removeLeadName));
                    System.out.println(commandResume);
                    break;

                case "showleads":
                    for (Lead lead : crud.getLeadList()) {
                        System.out.println(lead.toString());
                    }
                    System.out.println(commandResume);
                    break;

                case "showopportunities":
                    for (Opportunity opportunity : crud.getOpportunityList()) {
                        System.out.println(opportunity.toString());
                    }
                    System.out.println(commandResume);
                    break;

                case "showcontacts":
                    for (Contact contact : crud.getContactList()) {
                        System.out.println(contact.toString());
                    }
                    System.out.println(commandResume);
                    break;

                case "showaccounts":
                    for (Account account : crud.getAccountList()) {
                        System.out.println(account.toString());
                    }
                    System.out.println(commandResume);
                    break;

                case "lookuplead":
                    while (true) {
                        System.out.println("Enter ID lead to look for: ");
                        String userLeadID = userInput.nextLine();
                        try {
                            Lead leadFound = crud.getLeadByID(UUID.fromString(userLeadID));
                            System.out.println(leadFound.toString());
                            System.out.println(commandResume);
                            break;
                        } catch (Exception e) {
                            System.out.println("Not a valid ID");
                        }
                    }
                    break;

                case "convert":

                    String userLeadToConvert;
                    while(true) {
                        try {
                            System.out.println("Enter an id to look for: ");
                            userLeadToConvert = userInput.nextLine();
                            crud.getLeadByID(UUID.fromString(userLeadToConvert));
                            break;
                        } catch (Exception e) {
                            System.out.println("Not a valid ID");
                        }
                    }

                    System.out.println("\nChoose between: HYBRID, FLATBED or BOX: "); //TODO CONTROLAR ENUMS
                    ProductType product = ProductType.valueOf(userInput.nextLine());

                    System.out.println("\nHow many trucks?");
                    int trucks = userInput.nextInt(); //TODO CONTROLAR INT

                    Opportunity newOp = crud.convertFromLeadToOpportunity(UUID.fromString(userLeadToConvert), product, trucks);
                    System.out.println("\nA new opportunity has been created with id: " + newOp.getId());

                    System.out.println("\nCreating new account...............");
                    System.out.println("Enter industry [Produce/Ecommerce/Manufacturing/Medical]: ");

                    String industryName = userInput.nextLine();

                    Activity userIndustry = null;
                    for (Activity industry : Activity.values()) {
                        if (industryName == industry.name()) { //TODO CONTROLAR ENUMS
                            userIndustry = industry;
                        }
                    }

                    System.out.println("\nEnter the city: ");
                    String city = userInput.nextLine();

                    System.out.println("\nEnter the country: ");
                    String country = userInput.nextLine();

                    crud.createAndAddAccount(userIndustry, city, country);

                    System.out.println("Details of the new opportunity: " + newOp.toString());
                    System.out.println(commandResume);
                    break;

                case "close-lost":
                    System.out.println("Change an opportunity state to \"closed as lost\".\n" +
                            "Here is the list of available opportunities:\n");

                    for (Opportunity opportunity : crud.getOpportunityList()) {
                        System.out.println(opportunity.toString());
                    }

                    while(true) {
                        try {
                            System.out.println("Enter an id to look for: ");
                            String userOpportunityToChangeState = userInput.nextLine();
                            crud.closeOpportunityAsLost(UUID.fromString(userOpportunityToChangeState));
                            System.out.println(String.format("\nState for opportunity %s changed to \"lost\"", userOpportunityToChangeState));
                            System.out.println(commandResume);
                            break;
                        } catch (Exception e) {
                            System.out.println("\nNot a valid ID");
                            break;
                        }
                    }
                    break;

                case "close-won":
                    System.out.println("Change an opportunity state to \"closed as won\".\n" +
                            "Here is the list of available opportunities:\n");

                    for (Opportunity opportunity : crud.getOpportunityList()) {
                        System.out.println(opportunity.toString());
                    }

                    while(true) {
                        try {
                            System.out.println("Enter an id to look for: ");
                            String userOpportunityToChangeState = userInput.nextLine();
                            crud.closeOpportunityAsWon(UUID.fromString(userOpportunityToChangeState));
                            System.out.println(String.format("\nState for opportunity %s changed to \"won\"", userOpportunityToChangeState));
                            System.out.println(commandResume);
                            break;
                        } catch (Exception e) {
                            System.out.println("\nNot a valid ID");
                            break;
                        }
                    }
                    break;

                case "exit":
                    GitHub.push();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Not a valid option");
                    System.out.println(commandResume);
                    break;
            }
        }
    }
}