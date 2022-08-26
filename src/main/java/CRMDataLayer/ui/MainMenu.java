// TODO: fix shutdown

package CRMDataLayer.ui;

import java.util.List;
import java.util.Scanner;

import CRMDataLayer.enums.ProductType;
import CRMDataLayer.model.Lead;

import CRMDataLayer.model.SalesRep;
import CRMDataLayer.repository.LeadRepository;
import CRMDataLayer.repository.SalesRepRepository;
import CRMDataLayer.service.LeadService;
import CRMDataLayer.service.SalesRepService;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

/**
 * Management of the main menu and user input commands.
 */

@Service
public class MainMenu {
    @Autowired
    LeadService leadService;

    @Autowired
    SalesRepService salesRepService;

    @Autowired
     private ApplicationContext context;

    @Autowired
    SalesRepRepository salesRepRepository;

    @Autowired
    LeadRepository leadRepository;

    Scanner userInput;

    public MainMenu(ApplicationContext context) {
        this.context = context;
        userInput = new Scanner(System.in);
    }

    public void shutdown() {
        SpringApplication.exit(context);
        System.exit(0);
    }

    public void executeCommand() {

        System.out.println(TextMenus.intro);

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
                case "crm--help":
                    System.out.println(TextMenus.mainMenu);
                    break;

                case "crmsalesreprep":
                    System.out.println(TextMenus.reportingBySalesRep);
                    break;

                case "crmproductrep":
                    System.out.println(TextMenus.reportingByProduct);
                    break;

                case "crmcountryrep":
                    System.out.println(TextMenus.reportingByCountry);
                    break;

                case "crmcityrep":
                    System.out.println(TextMenus.reportingByCity);
                    break;

                case "crmindustryrep":
                    System.out.println(TextMenus.reportingByIndustry);
                    break;

                case "crmemployeerep":
                    System.out.println(TextMenus.employeeCountState);
                    break;

                case "crmquantityrep":
                    System.out.println(TextMenus.quantityState);
                    break;

                case "crmopportunityrep":
                    System.out.println(TextMenus.opportunityState);
                    break;

                case "crmnewlead":
                    newLead();
                    break;

                case "crmremovelead":
                    removeLead();
                    break;

                case "crmshowleads":
                    showLeads();
                    break;

                case "showsalesreps":
                    showSalesReps();
                    break;


                case "crmshowopportunities":
                    showopportunities();
                    break;

                case "crmshowcontacts":
                    showcontacts();
                    break;

                case "crmshowaccounts":
                    showaccounts();
                    break;

                case "crmlookuplead":
                    lookuplead();
                    break;

                case "crmconvert":
                    convert();
                    break;

                case "crmclose-lost":
                    closeLost();
                    break;

                case "crmclose-won":
                    closeWon();
                    break;

                case "crmnewsalesrep":
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
                    System.out.println("See you in future sessions...");
                    shutdown();

                default:
                    System.out.println("Not a valid option");
                    break;
            }
            System.out.println(TextMenus.intro);
        }
    }

    public void newLead() {
        System.out.println("\nEnter name for the new lead: ");
        String leadName = this.userInput.nextLine();
        System.out.println("\nPhone number: ");
        String leadPhone = this.userInput.nextLine();
        System.out.println("\nEmail: ");
        String leadMail = this.userInput.nextLine();
        System.out.println("\nCompany name: ");
        String companyLead = this.userInput.nextLine();
        System.out.println("\nSalesRep Id");
        Long salesRepId = this.userInput.nextLong();
        if (this.salesRepRepository.findById(salesRepId).isPresent()) {
            this.leadRepository.save(new Lead("Raul", "45446556", "sadasd@sdas.com", "company", this.salesRepService.findBySalesRepId(salesRepId)));
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
    public void  showSalesReps() {
        List<SalesRep> salesRep = salesRepService.findAll();
        System.out.println(salesRep);
    }

    public void showcontacts() {
    }

    public void showaccounts() {
    }

    public void lookuplead() {
    }

    public void convert() {

        System.out.println("Would you like to create a new Account? (Y/N)");
        String s = userInput.nextLine();

        if (s.equals("Y")){
            System.out.println("Enter an id to look for: ");
            String userLeadToConvert = userInput.nextLine();

            System.out.println("\nChoose between: HYBRID, FLATBED or BOX: ");
            ProductType product = ProductType.valueOf(userInput.nextLine().toUpperCase());

            System.out.println("\nHow many trucks?");
            String stringTrucks = userInput.nextLine();

            System.out.println("Enter industry [Produce/Ecommerce/Manufacturing/Medical]: ");
            String industryName = CommandInterpreter.InputToCommand(userInput.nextLine());

            System.out.println("\nEnter the city: ");
            String city = userInput.nextLine();

            System.out.println("\nEnter the country: ");
            String country = userInput.nextLine();
        } else if(s.equals("N")){

        }

    }

    public void closeLost() {
    }

    public void closeWon() {
    }

    public void newSalesRep() {
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