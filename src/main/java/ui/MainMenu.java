package ui;

import java.util.Scanner;
import java.util.UUID;

import customer.*;
import dbInteraction.Database;
import dbInteraction.GitHub;

public class MainMenu {

    private final String mainMenu = "\n\n================= Welcome to IronCRM =================\n" +
            "\nUse this tool to interact with your Lead database\n" +
            "and perform operations from them:\n\n" +
            "\t\"showleads\": shows a list of all leads presents in database.\n" +
            "\t\"lookuplead\": returns an specific lead, searched by id.\n" +
            "\t\"newlead\": creates a new lead by asking for the new info.\n" +
            "\t\"removelead\": removes the lead associated with specified id.\n" +
            "\t\"convert\": converts a lead into an opportunity and creates \n" +
            "\t\tits associated contact and account.\n" +
            "\t\"exit\": exits the program.\n";

    private final String commandResume = "\n\nCheatsheet:\n" +
            "showleads: prints a list of all leads\n" +
            "lookuplead: prints a specific lead found by id\n" +
            "newlead: creates a new lead providing all data\n" +
            "removelead: removes a lead, specified by id\n" +
            "convert: converts a lead to an opportunity, in the process creates a new contact and account.\n" +
            "exit: exits the program\n";
    public void executeCommand() {

        Scanner userInput = new Scanner(System.in);

        Database db = new Database();

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

                    db.createAndAddLead(leadName, leadPhone, leadMail, companyLead);

                    System.out.println(commandResume);
                    break;

                case "removelead":
                    System.out.println("\nEnter id for the lead to remove: ");
                    String userIdLeadToRemove = userInput.nextLine();

                    db.removeLeadByID(UUID.fromString(userIdLeadToRemove));

                    System.out.println(commandResume);
                    break;

                case "showleads":
                    for (Lead lead : db.getLeadList()) {
                        System.out.println(lead.toString());
                    }
                    System.out.println(commandResume);
                    break;

                case "lookuplead":
                    System.out.println("Enter ID lead to look for: ");
                    String userLeadID = userInput.nextLine();

                    Lead leadFound = db.getLeadByID(UUID.fromString(userLeadID));
                    System.out.println(leadFound.toString());
                    System.out.println(commandResume);
                    break;

                case "convert":
                    System.out.println("Enter an id to look for: ");
                    String userLeadToConvert = userInput.nextLine();

                    System.out.println("\nChoose between: HYBRID, FLATBED or BOX: ");
                    ProductType product = ProductType.valueOf(userInput.nextLine());

                    System.out.println("\nHow many trucks?");
                    int trucks = userInput.nextInt();

                    Opportunity newOp = db.convertFromLeadToOpportunity(UUID.fromString(userLeadToConvert), product, trucks);
                    System.out.println("\nA new opportunity has been created with id: " + newOp.getId());

                    System.out.println("\nCreating new account...............");
                    System.out.println("Enter industry [Produce/Ecommerce/Manufacturing/Medical]: ");

                    String industryName = userInput.nextLine();

                    Activity userIndustry = null;
                    for (Activity industry : Activity.values()) {
                        if (industryName == industry.name()) {
                            userIndustry = industry;
                        }
                    }

                    System.out.println("\nEnter the city: ");
                    String city = userInput.nextLine();

                    System.out.println("\nEnter the country: ");
                    String country = userInput.nextLine();

                    db.createAndAddAccount(userIndustry, city, country);

                    System.out.println("Details of the new opportunity: " + newOp.toString());
                    System.out.println(commandResume);
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