package CRMDataLayer.ui;

import java.util.List;
import java.util.Scanner;

import CRMDataLayer.model.Lead;
import CRMDataLayer.repository.LeadRepository;
import CRMDataLayer.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Management of the main menu and user input commands.
 */

@Service
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

            "\n\t\tReporting By SalesRep\n"+
            "\t\"Report Lead by SalesRep\": A count of Leads by SalesRep\n" +
            "\t\"Report Opportunity by SalesRep\": A count of all Opportunities by SalesRep\n" +
            "\t\"Report CLOSED-WON by SalesRep\": A count of all CLOSED_WON Opportunities\n" +
            "\t\"Report CLOSED-LOST by SalesRep\": A count of all CLOSED_LOST Opportunities by SalesRep\n" +
            "\t\"Report OPEN by SalesRep\": A count of all OPEN Opportunities by SalesRep\n" +

            "\n\t\tReporting By Product\n"+
            "\t\"Report Opportunity by the product\": A count of all Opportunities by the product\n" +
            "\t\"Report CLOSED-WON by the product\": A count of all CLOSED_WON Opportunities by the product\n" +
            "\t\"Report CLOSED-LOST by the product\": A count of all CLOSED_LOST Opportunities by the product\n" +
            "\t\"Report OPEN by the product\": A count of all OPEN Opportunities by the product\n" +

            "\n\t\tReporting By Country\n"+
            "\t\"Report Opportunity by Country\": A count of all Opportunities by country\n" +
            "\t\"Report CLOSED-WON by Country\": A count of all CLOSED_WON Opportunities by country\n" +
            "\t\"Report CLOSED-LOST by Country\": A count of all CLOSED_LOST Opportunities by country\n" +
            "\t\"Report OPEN by Country\": A count of all OPEN Opportunities by country\n" +

            "\n\t\tReporting By City\n"+
            "\t\"Report Opportunity by City\": A count of all Opportunities by City\n" +
            "\t\"Report CLOSED-WON by City\": A count of all CLOSED_WON Opportunities by City\n" +
            "\t\"Report CLOSED-LOST by City\": A count of all CLOSED_LOST Opportunities by City\n" +
            "\t\"Report OPEN by City\": A count of all OPEN Opportunities by City\n" +

            "\n\t\tReporting By Industry\n"+
            "\t\"Report Opportunity by Industry\": A count of all Opportunities by Industry\n" +
            "\t\"Report CLOSED-WON by Industry\": A count of all CLOSED_WON Opportunities by Industry\n" +
            "\t\"Report CLOSED-LOST by Industry\": A count of all CLOSED_LOST Opportunities by Industry\n" +
            "\t\"Report OPEN by Industry\": A count of all OPEN Opportunities by Industry\n" +

            "\n\t\tReporting EmployeeCount States\n"+
            "\t\"Mean EmployeeCount\": The mean employeeCount\n" +
            "\t\"Median EmployeeCount\": The median employeeCount\n" +
            "\t\"Max EmployeeCount\": The maximum employeeCount\n" +
            "\t\"Min EmployeeCount\": The minimum employeeCount\n" +

            "\n\t\tReporting Quantity States\n"+
            "\t\"Mean Quantity\": The mean Quantity of products\n" +
            "\t\"Median Quantity\": The median Quantity of products\n" +
            "\t\"Max Quantity\": The maximum Quantity of products\n" +
            "\t\"Min Quantity\": The minimum Quantity of products\n" +

            "\n\t\tReporting EmployeeCount States\n"+
            "\t\"Mean Opps per Account\": The mean number of Opportunities associated with an Account\n" +
            "\t\"Median Opps per Account\": The median number of Opportunities associated with an Account \n" +
            "\t\"Max Opps per Account\": The maximum number of Opportunities associated with an Account\n" +
            "\t\"Min Opps per Account\": The minimum number of Opportunities associated with an Account\n" +


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
            "reportleadbysalesrep: A count of Leads by SalesRep\n"+
            "reportopportunitybysalesrep: A count of all Opportunities by SalesRep\n"+
            "reportclosed-wonbysalesrep: A count of all CLOSED_WON Opportunities\n"+
            "reportclosed-lostbysalesrep: A count of all CLOSED_LOST Opportunities by SalesRep\n"+
            "reportopenbysalesrep: A count of all OPEN Opportunities by SalesRep\n"+
            "reportopportunitybytheproduct: A count of all Opportunities by the product\n"+
            "reportclosed-wonbytheproduct: A count of all CLOSED_WON Opportunities by the product\n"+
            "reportclosed-lostbytheproduct: A count of all CLOSED_LOST Opportunities by the product\n"+
            "reportopenbytheproduct: A count of all OPEN Opportunities by the product\n"+
            "reportopportunitybycountry: A count of all Opportunities by country\n"+
            "reportclosed-wonbycountry: A count of all CLOSED_WON Opportunities by country\n"+
            "reportclosed-lostbycountry: A count of all CLOSED_LOST Opportunities by country\n"+
            "reportopenbycountry: A count of all OPEN Opportunities by country\n"+
            "reportopportunitybycity: A count of all Opportunities by City\n"+
            "reportclosed-wonbycity: A count of all CLOSED_WON Opportunities by City\n"+
            "reportclosed-lostbycity: A count of all CLOSED_LOST Opportunities by City\n"+
            "reportopenbycity: A count of all OPEN Opportunities by City\n"+
            "reportopportunitybyindustry: A count of all Opportunities by Industry\n"+
            "reportclosed-wonbyindustry: A count of all CLOSED_WON Opportunities by Industry\n"+
            "reportclosed-lostbyindustry: A count of all CLOSED_LOST Opportunities by Industry\n"+
            "reportopenbyindustry: A count of all OPEN Opportunities by Industry\n"+
            "meanemployeecount: The mean employeeCount\n"+
            "medianemployeecount: The median employeeCount\n"+
            "maxemployeecount: The maximum employeeCount\n"+
            "minemployeecount: The minimum employeeCount\n"+
            "meanquantity: The mean Quantity of products\n"+
            "medianquantity: The median Quantity of products\n"+
            "maxquantity: The maximum Quantity of products\n"+
            "minquantity: The minimum Quantity of products\n"+
            "meanoppsperaccount: The mean number of Opportunities associated with an Account\n"+
            "medianoppsperaccount: The median number of Opportunities associated with an Account \n"+
            "maxoppsperaccount: The maximum number of Opportunities associated with an Account\n"+
            "minoppsperaccount: The minimum number of Opportunities associated with an Account\n"+
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
                    showLeads();
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

                case ("reportleadbysalesrep"):
                    reportLeadBySalesRep();
                    break;
                    
                case ("reportopportunitybysalesrep"):
                    reportOpportunityBySalesRep();
                    break;
                    
                case ("reportclosed-wonbysalesrep"):
                    reportClosedWonBySalesRep();
                    break;
                    
                case ("reportclosed-lostbysalesrep"):
                    reportClosedLostBySalesRep();
                    break;
                    
                case ("reportopenbysalesrep"):
                    reportopenBySalesRep();
                    break;
                    
                case ("reportopportunitybytheproduct"):
                    reportOpportunityByProduct();
                    break;
                    
                case ("reportclosed-wonbytheproduct"):
                    reportClosedWonByProduct();
                    break;
                    
                case ("reportclosed-lostbytheproduct"):
                    reportClosedLostByProduct();
                    break;
                    
                case ("reportopenbytheproduct"):
                    reportOpenByProduct();
                    break;
                    
                case ("reportopportunitybycountry"):
                    reportOpportunityByCountry();
                    break;
                    
                case ("reportclosed-wonbycountry"):
                    reportClosedWonByCountry();
                    break;
                    
                case ("reportclosed-lostbycountry"):
                    reportClosedLostByCountry();
                    break;
                    
                case ("reportopenbycountry"):
                    reportopenByCountry();
                    break;
                    
                case ("reportopportunitybycity"):
                    reportOpportunityByCity();
                    break;
                    
                case ("reportclosed-wonbycity"):
                    reportClosedWonByCity();
                    break;
                    
                case ("reportclosed-lostbycity"):
                    reportClosedLostByCity();
                    break;
                    
                case ("reportopenbycity"):
                    reportOpenByCity();
                    break;
                    
                case ("reportopportunitybyindustry"):
                    reportOpportunityByIndustry();
                    break;
                    
                case ("reportclosed-wonbyindustry"):
                    reportClosedWonByIndustry();
                    break;
                    
                case ("reportclosed-lostbyindustry"):
                    reportClosedLostByIndustry();
                    break;
                    
                case ("reportopenbyindustry"):
                    reportOpenByIndustry();
                    break;
                    
                case ("meanemployeecount"):
                    meanEmployeeCount();
                    break;
                    
                case ("medianemployeecount"):
                    medianEmployeeCount();
                    break;
                    
                case ("maxemployeecount"):
                    maxEmployeeCount();
                    break;
                    
                case ("minemployeecount"):
                    minEmployeeCount();
                    break;
                    
                case ("meanquantity"):
                    meanQuantity();
                    break;
                    
                case ("medianquantity"):
                    medianQuantity();
                    break;
                    
                case ("maxquantity"):
                    maxQuantity();
                    break;
                    
                case ("minquantity"):
                    minQuantity();
                    break;
                    
                case ("meanoppsperaccount"):
                    meanOppsPerAccount();
                    break;
                    
                case ("medianoppsperaccount"):
                    medianOppsPerAccount();
                    break;
                    
                case ("maxoppsperaccount"):
                    maxOppsPerAccount();
                    break;
                    
                case ("minoppsperaccount"):
                    minOppsPerAccount();
                    break;                
                
                case "exit":
                    System.exit(0);
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
        List<Lead> leads = this.leadService.findAll();
        System.out.println(leads);
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

    public void reportLeadBySalesRep(){

    }
    
    public void reportOpportunityBySalesRep(){
    
    }
    
    public void reportClosedWonBySalesRep(){
    
    }
    
    public void reportClosedLostBySalesRep(){
    
    }
    
    public void reportopenBySalesRep(){
    
    }
    
    public void reportOpportunityByProduct(){
    
    }
    
    public void reportClosedWonByProduct(){
    
    }
    
    public void reportClosedLostByProduct(){
    
    }
    
    public void reportOpenByProduct(){
    
    }
    
    public void reportOpportunityByCountry(){
    
    }
    
    public void reportClosedWonByCountry(){
    
    }
    
    public void reportClosedLostByCountry(){
    
    }
    
    public void reportopenByCountry(){
    
    }
    
    public void reportOpportunityByCity(){
    
    }
    
    public void reportClosedWonByCity(){
    
    }
    
    public void reportClosedLostByCity(){
    
    }
    
    public void reportOpenByCity(){
    
    }
    
    public void reportOpportunityByIndustry(){
    
    }
    
    public void reportClosedWonByIndustry(){
    
    }
    
    public void reportClosedLostByIndustry(){
    
    }
    
    public void reportOpenByIndustry(){
    
    }
    
    public void meanEmployeeCount(){
    
    }
    
    public void medianEmployeeCount(){
    
    }
    
    public void maxEmployeeCount(){
    
    }
    
    public void minEmployeeCount(){
    
    }
    
    public void meanQuantity(){
    
    }
    
    public void medianQuantity(){
    
    }
    
    public void maxQuantity(){
    
    }
    
    public void minQuantity(){
    
    }
    
    public void meanOppsPerAccount(){
    
    }
    
    public void medianOppsPerAccount(){
    
    }
    
    public void maxOppsPerAccount(){
    
    }
    
    public void minOppsPerAccount(){
    
    }
    
}