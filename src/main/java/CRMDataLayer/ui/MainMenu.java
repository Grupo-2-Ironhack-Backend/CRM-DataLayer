package CRMDataLayer.ui;

import java.util.Scanner;

import CRMDataLayer.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Management of the main menu and user input commands.
 */

public class MainMenu {
    @Autowired
    LeadService leadService;

    Scanner userInput;
    private final String mainMenu = "\n\n================= Welcome to IronCRM =================\n" +
            "\nUse this tool to interact with your Lead database\n" +
            "and perform operations from them:\n\n" +
            "\t\"showleads\": shows a list of all leads presents in database.\n" +
            "\t\"showopportunities\": shows a list of all Opportunities presents in database.\n" +
            "\t\"showcontacts\": shows a list of all contacts presents in database.\n" +
            "\t\"showaccounts\": shows a list of all accounts presents in database.\n" +
            "\t\"lookuplead\": returns an specific lead, searched by id.\n" +
            "\t\"newlead\": creates a new lead by asking for the new info.\n" +
            "\t\"removelead\": removes the lead associated with specified id.\n" +
            "\t\"New SalesRep\": \n" +
            "\t\"convert\": converts a lead into an opportunity and creates \n" +
            "\t\t\tits associated contact and account.\n" +
            "\t\"close-lost\": changes opportunity status to \"CLOSED-LOST\" to\n" +
            "\t\t\treflect that this opportunity will not become a sale.\n" +
            "\t\"close-won\": changes opportunity status to \"CLOSED-WON\" to\n" +
            "\t\t\treflect that this opportunity will become a sale." +
            "\t\"exit\": exits the program.\n";

    private final String commandResume = "\n\n================= Cheatsheet: =================\n\n" +
            "showleads: list of leads\n" +
            "showopportunities: list of Opportunities\n" +
            "showcontacts: list of contacts\n" +
            "showaccounts: list of accounts\n" +
            "lookuplead: specific lead by id\n" +
            "newlead: create a new lead\n" +
            "removelead: removes a lead\n" +
            "convert: converts a lead to an opportunity\n" +
            "close-lost: opportunity status changed to lost sale\n" +
            "close-won: opportunity status changed to won sale\n" +
            "newsalesrep: create a new salesrep\n" +
            "exit: exits the program\n";

    public MainMenu() {
        userInput = new Scanner(System.in);
    }

    public void executeCommand() {

        System.out.println(mainMenu);

        while (true) {


            String userCommand = null;
            try {
                userCommand = userInput.nextLine();
                String command = CommandInterpreter.InputToCommand(userCommand);
            } catch (Exception e) {
                System.out.println("Not a valid option");
            }

            String command = CommandInterpreter.InputToCommand(userCommand);

            switch (command) {
                case "newlead":
                    newLead();
                    break;

                case "removelead":
                    removeLead();
                    break;

                case "showleads":
                    leadService.findAll();
                    break;

                case "showopportunities":
                    showopportunities();
                    break;

                case "showcontacts":
                    showcontacts();
                    break;

                case "showaccounts":
                    showaccounts();
                    break;

                case "lookuplead":
                    lookuplead();
                    break;

                case "convert":
                    convert();
                    break;

                case "close-lost":
                    closeLost();
                    break;

                case "close-won":
                    closeWon();
                    break;

                case "newsalesrep":
                    newSalesRep();
                    break;

                case "exit":
                    System.exit(0);
                    break;

                case "newsalesreps":
                    newSalesRep();
                    break;

                default:
                    System.out.println("Not a valid option");
                    System.out.println(commandResume);
                    break;
            }
        }
    }

    public void newLead(){
        System.out.println("\nEnter name for the new lead: ");
        String leadName = userInput.nextLine();

        System.out.println("\nPhone number: ");
        String leadPhone = userInput.nextLine();

        System.out.println("\nEmail: ");
        String leadMail = userInput.nextLine();

        System.out.println("\nCompany name: ");
        String companyLead = userInput.nextLine();

        System.out.println(commandResume);
    }

    public void removeLead(){
    }

    public void showLeads(){
    }

    public void showopportunities(){
    }

    public void showcontacts(){
    }

    public void showaccounts(){
    }

    public void lookuplead(){
    }

    public void convert(){
    }

    public void closeLost(){
    }

    public void closeWon(){
    }

    public void newSalesRep(){
    }
}