package CRMDataLayer.ui;

import java.util.List;
import java.util.Scanner;

import CRMDataLayer.enums.ProductType;
import CRMDataLayer.model.*;

import CRMDataLayer.repository.AccountRepository;
import CRMDataLayer.repository.ContactRepository;
import CRMDataLayer.repository.OpportunityRepository;
import CRMDataLayer.repository.SalesRepRepository;
import CRMDataLayer.enums.Activity;
import CRMDataLayer.enums.Status;

import CRMDataLayer.repository.*;
import CRMDataLayer.service.LeadService;
import CRMDataLayer.service.OpportunityService;
import CRMDataLayer.service.SalesRepService;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/**
 * @Author: TheBigFive {Kat, Paula, Jhon, Gerard & Alex}
 * @Since: 26/08/2022
 * @Version: 1.2.35
 *
 * @Method Shutdown()
 * @Param: ApplicationContext
 * @Return: void
 * Exists the application first, then the system.
 *
 * @Method: executeCommand()
 * @Param: none
 * Initiates user input flux, receives command entered
 * via keyboard, it is formatted in
 * @See commandInterpreter() then filtered via switch
 * loop and executed via services
 *
 * @Method: newLead()
 * @Param: none
 * Creates a new lead through user input
 *
 * @Method: showLeads()
 * @Param: none
 * Shows a list of leads in database
 */

@Service
public class MainMenu {
    @Autowired
    LeadService leadService;
    @Autowired
    SalesRepRepository salesRepRepository;
    @Autowired
    SalesRepService salesRepService;
    @Autowired
    OpportunityService opportunityService;
    @Autowired
    OpportunityRepository opportunityRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
     private ApplicationContext context;



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

                case "crmshowsalesreps":
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
            this.leadRepository.save(new Lead(leadName, leadPhone, leadMail, companyLead, salesRepService.findBySalesRepId(salesRepId)));
        } else {
            System.out.println("No existe ese ID");
        }


        // Adding the Sales Rep from the ones available in the database
        SalesRep salesRep;
        while (true) {
            System.out.println("\nAssign a Sales Representative to this lead (Type the ID): ");
            showSalesReps();
            try {
                salesRep = salesRepRepository.findById(userInput.nextLong()).get();
                break;
            } catch (Exception e) {
                System.err.println("Not a valid ID");
            }
        }
        Lead newLead = new Lead(leadName, leadPhone, leadMail, companyLead);
        newLead.setSalesRep(salesRep);
        leadService.addNew(newLead);
        System.out.println("SAVED!");

    }

    public void removeLead() {
    }

    public void showLeads() {
        List<Lead> leads = this.leadService.findAll();

        for (Lead lead : leads) {
            System.out.println("Id: " + lead.getId() + " | Name: " + lead.getName() + " | Company: " + lead.getCompanyName());

        }
    }

    public void showopportunities() {
        List<Opportunity> opportunities = opportunityRepository.findAll();
        for (Opportunity opportunity : opportunities) {
            System.out.println("Id: " + opportunity.getId() +
                       " | Product: " + opportunity.getProductType() +
                        " | Trucks: " + opportunity.getNumberOfTrucks() +
                        " | Status: " + opportunity.getStatus());
        }
    }
    public void showSalesReps() {
        List<SalesRep> salesRep = salesRepService.findAll();
        for (SalesRep salesRep_i : salesRep) {
            System.out.println("Id: " + salesRep_i.getId() + " | Name: " + salesRep_i.getName());
        }
    }

    public void showcontacts() {
        List<Contact> contacts = contactRepository.findAll();
        for (Contact contact : contacts) {
            System.out.println("Id: " + contact.getId() + " | Name: " + contact.getName());
        }
    }

    public void showaccounts() {

        List<Account> accounts = accountRepository.findAll();
for (Account account : accounts) {
            System.out.println("Id: " + account.getId() + " | Industry: " + account.getIndustry() + " | City: " + account.getCity());
        }


    }

    public void lookuplead() {
    }

    public void convert() {

        Long id;
        ProductType productType = null;
        int trucks;
        Opportunity opportunity;
        Lead lead;
        Activity activity = null;
        Account account = null;
        Contact contact;

        while (true) {
            try {
                System.out.println("Escriba el ID: ");
                showLeads();
                id = this.userInput.nextLong();
                if (leadService.findById(id) == null) {
                    System.out.println("Id no encontrado");
                    showLeads();
                    int n = Integer.parseInt("M");
                }
                System.out.println("EXITO");
                break;
            } catch (Exception e) {
                e.getMessage();
            }
        }

        lead = leadService.findById(id);
        contact = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
        leadRepository.delete(lead);

        while (true) {
            try {
                userInput = new Scanner(System.in);
                System.out.println("Elija entre: HYBRID, FLATBED o BOX: ");
                String s = this.userInput.nextLine().toUpperCase();
                switch (s) {
                    case "HYBRID":
                        productType = ProductType.HYBRID;
                        System.out.println("EXITO");
                        break;
                    case "BOX":
                        productType = ProductType.BOX;
                        System.out.println("EXITO");
                        break;
                    case "FLATBED":
                        productType = ProductType.FLATBED;
                        System.out.println("EXITO");
                        break;
                    default:
                        System.out.println("No se ha encontrado tu tipo de producto");
                        int n = Integer.parseInt("M");
                }
                break;
            } catch (Exception e) {
                e.getMessage();
            }
        }

        while (true) {
            try {
                System.out.println("\nHow many trucks?");
                String stringTrucks = userInput.nextLine();
                trucks = Integer.parseInt(stringTrucks);
                break;
            } catch (Exception e) {
                System.out.println("Not a numeric value");
            }
        }

        opportunity = new Opportunity(productType, trucks, Status.OPEN, lead.getSalesRep());
        opportunity.setDecisionMaker(contact);
        opportunity.setSalesRep(lead.getSalesRep());

        System.out.println("Would you like to create a new Account? (Y/N)");
        String s = userInput.nextLine().toUpperCase();

        Long accountId = null;
        if (s.equals("Y")) {
            System.out.println("Enter industry [Produce/Ecommerce/Manufacturing/Medical]: ");
            String s1 = userInput.nextLine();
            switch (s1) {
                case "Produce":
                    activity = Activity.PRODUCE;
                    break;
                case "Ecommerce":
                    activity = Activity.ECOMMERCE;
                    break;
                case "Manufacturing":
                    activity = Activity.MANUFACTURING;
                    break;
                case "Medical":
                    activity = Activity.MEDICAL;
                    break;
            }
            System.out.println("\nEnter the city: ");
            String city = userInput.nextLine();

            System.out.println("\nEnter the country: ");
            String country = userInput.nextLine();

            account = new Account(activity, city, country);
            accountRepository.save(account);


        } else if (s.equals("N")) {
            userInput = new Scanner(System.in);
            System.out.println("Enter an id to look for: ");
            showaccounts();
            accountId = userInput.nextLong();
            account = accountRepository.findById(accountId).get();
        } else {
            System.out.println("Elige una opción correcta");
        }

        contact.setAccount(account);
        opportunity.setAccount(account);
        contactRepository.save(contact);
        opportunityRepository.save(opportunity);


    }
    public void associateAccount(){

    }

    public void createAccount() {
    }
    public void closeLost() {
    }

    public void closeWon() {
    }

    public void newSalesRep() {

        System.out.println("\nEnter name for the new Sales Representative: ");
        SalesRep salesRep = new SalesRep(userInput.nextLine());
        salesRepRepository.save(salesRep);
        System.out.println("Saved in DB!: " + salesRep.getName() + " " + salesRep.getId());

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