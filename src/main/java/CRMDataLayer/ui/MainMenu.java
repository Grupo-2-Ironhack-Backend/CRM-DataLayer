package CRMDataLayer.ui;

import java.util.List;
import java.util.Scanner;

import CRMDataLayer.model.Lead;
import CRMDataLayer.model.SalesRep;
import CRMDataLayer.repository.LeadRepository;
import CRMDataLayer.repository.SalesRepRepository;
import CRMDataLayer.service.LeadService;
import CRMDataLayer.service.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Management of the main menu and user input commands.
 */

@Service
public class MainMenu {
    @Autowired
    LeadService leadService;

    @Autowired
    LeadRepository leadRepository;

    @Autowired
    SalesRepRepository salesRepRepository;

    @Autowired
    SalesRepService salesRepService;

    Scanner userInput;
    private final String reportingMenuResume = "\n\n\tReporting By SalesRep\n\n" +
            "\t\"Report Lead by SalesRep\": A count of Leads by SalesRep\n" +
            "\t\"Report Opportunity by SalesRep\": A count of all Opportunities by SalesRep\n" +
            "\t\"Report CLOSED-WON by SalesRep\": A count of all CLOSED_WON Opportunities\n" +
            "\t\"Report CLOSED-LOST by SalesRep\": A count of all CLOSED_LOST Opportunities by SalesRep\n" +
            "\t\"Report OPEN by SalesRep\": A count of all OPEN Opportunities by SalesRep\n" +

            "\n\tReporting By Product\n\n" +
            "\t\"Report Opportunity by the product\": A count of all Opportunities by the product\n" +
            "\t\"Report CLOSED-WON by the product\": A count of all CLOSED_WON Opportunities by the product\n" +
            "\t\"Report CLOSED-LOST by the product\": A count of all CLOSED_LOST Opportunities by the product\n" +
            "\t\"Report OPEN by the product\": A count of all OPEN Opportunities by the product\n" +

            "\n\tReporting By Country\n\n" +
            "\t\"Report Opportunity by Country\": A count of all Opportunities by country\n" +
            "\t\"Report CLOSED-WON by Country\": A count of all CLOSED_WON Opportunities by country\n" +
            "\t\"Report CLOSED-LOST by Country\": A count of all CLOSED_LOST Opportunities by country\n" +
            "\t\"Report OPEN by Country\": A count of all OPEN Opportunities by country\n" +

            "\n\tReporting By City\n\n" +
            "\t\"Report Opportunity by City\": A count of all Opportunities by City\n" +
            "\t\"Report CLOSED-WON by City\": A count of all CLOSED_WON Opportunities by City\n" +
            "\t\"Report CLOSED-LOST by City\": A count of all CLOSED_LOST Opportunities by City\n" +
            "\t\"Report OPEN by City\": A count of all OPEN Opportunities by City\n" +

            "\n\tReporting By Industry\n\n" +
            "\t\"Report Opportunity by Industry\": A count of all Opportunities by Industry\n" +
            "\t\"Report CLOSED-WON by Industry\": A count of all CLOSED_WON Opportunities by Industry\n" +
            "\t\"Report CLOSED-LOST by Industry\": A count of all CLOSED_LOST Opportunities by Industry\n" +
            "\t\"Report OPEN by Industry\": A count of all OPEN Opportunities by Industry\n" +

            "\n\tReporting EmployeeCount States\n\n" +
            "\t\"Mean EmployeeCount\": The mean employeeCount\n" +
            "\t\"Median EmployeeCount\": The median employeeCount\n" +
            "\t\"Max EmployeeCount\": The maximum employeeCount\n" +
            "\t\"Min EmployeeCount\": The minimum employeeCount\n" +

            "\n\tReporting Quantity States\n\n" +
            "\t\"Mean Quantity\": The mean Quantity of products\n" +
            "\t\"Median Quantity\": The median Quantity of products\n" +
            "\t\"Max Quantity\": The maximum Quantity of products\n" +
            "\t\"Min Quantity\": The minimum Quantity of products\n" +

            "\n\tReporting EmployeeCount States\n\n" +
            "\t\"Mean Opps per Account\": The mean number of Opportunities associated with an Account\n" +
            "\t\"Median Opps per Account\": The median number of Opportunities associated with an Account \n" +
            "\t\"Max Opps per Account\": The maximum number of Opportunities associated with an Account\n" +
            "\t\"Min Opps per Account\": The minimum number of Opportunities associated with an Account\n\n";

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
            reportingMenuResume +
            "\t\"exit\": exits the program.\n";

    private final String commandResume = "\n\n================= Cheatsheet: =================\n\n" +
            "\t\"showleads\": list of leads\n" +
            "\t\"showopportunities\": list of Opportunities\n" +
            "\t\"showcontacts\": list of contacts\n" +
            "\t\"showaccounts\": list of accounts\n" +
            "\t\"lookuplead\": specific lead by id\n" +
            "\t\"newlead\": create a new lead\n" +
            "\t\"removelead\": removes a lead\n" +
            "\t\"convert\": converts a lead to an opportunity\n" +
            "\t\"close-lost\": opportunity status changed to lost sale\n" +
            "\t\"close-won\": opportunity status changed to won sale\n" +
            "\t\"newsalesrep\": create a new salesrep\n" +
            reportingMenuResume +
            "\t\"exit\": exits the program\n";

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

                    break;
            }
            System.out.println(commandResume);
        }
    }

    public void newLead() {
        System.out.println("\nEnter name for the new lead: ");
        String leadName = userInput.nextLine();

        System.out.println("\nPhone number: ");
        String leadPhone = userInput.nextLine();

        System.out.println("\nEmail: ");
        String leadMail = userInput.nextLine();

        System.out.println("\nCompany name: ");
        String companyLead = userInput.nextLine();

        System.out.println("\nSalesRep Id");
        Long salesRepId = userInput.nextLong();

        if (this.salesRepRepository.findById(salesRepId).isPresent()){
            leadRepository.save(new Lead("Raul","45446556","sadasd@sdas.com","company",salesRepService.findBySalesRepId(salesRepId)));
        } else {
            System.out.println("No existe ese ID");
        }
    }

    public void removeLead() {
    }

    public void showLeads() {
        List<Lead> leads = this.leadService.findAll();
        System.out.println(leads);
    }

    public void showopportunities() {
    }

    public void showcontacts() {
    }

    public void showaccounts() {
    }

    public void lookuplead() {
    }

    public void convert() {
    }

    public void closeLost() {
    }

    public void closeWon() {
    }

    public void newSalesRep() {
        System.out.println("\nEnter name for the new SalesRep: ");
        String salesRep = userInput.nextLine();
        salesRepRepository.save(new SalesRep(salesRep));
    }

    public void reportLeadBySalesRep() {

    }

    public void reportOpportunityBySalesRep() {

    }

    public void reportClosedWonBySalesRep() {

    }

    public void reportClosedLostBySalesRep() {

    }

    public void reportopenBySalesRep() {

    }

    public void reportOpportunityByProduct() {

    }

    public void reportClosedWonByProduct() {

    }

    public void reportClosedLostByProduct() {

    }

    public void reportOpenByProduct() {

    }

    public void reportOpportunityByCountry() {

    }

    public void reportClosedWonByCountry() {

    }

    public void reportClosedLostByCountry() {

    }

    public void reportopenByCountry() {

    }

    public void reportOpportunityByCity() {

    }

    public void reportClosedWonByCity() {

    }

    public void reportClosedLostByCity() {

    }

    public void reportOpenByCity() {

    }

    public void reportOpportunityByIndustry() {

    }

    public void reportClosedWonByIndustry() {

    }

    public void reportClosedLostByIndustry() {

    }

    public void reportOpenByIndustry() {

    }

    public void meanEmployeeCount() {

    }

    public void medianEmployeeCount() {

    }

    public void maxEmployeeCount() {

    }

    public void minEmployeeCount() {

    }

    public void meanQuantity() {

    }

    public void medianQuantity() {

    }

    public void maxQuantity() {

    }

    public void minQuantity() {

    }

    public void meanOppsPerAccount() {

    }

    public void medianOppsPerAccount() {

    }

    public void maxOppsPerAccount() {

    }

    public void minOppsPerAccount() {

    }

}