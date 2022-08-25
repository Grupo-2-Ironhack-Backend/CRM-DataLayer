package CRMDataLayer.customer;

import CRMDataLayer.enums.Activity;
import CRMDataLayer.enums.ProductType;
import CRMDataLayer.enums.Status;
import CRMDataLayer.model.Account;
import CRMDataLayer.model.Contact;
import CRMDataLayer.model.Opportunity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    Contact contact;
    Opportunity opportunity;
    List<Opportunity> opportunityList;
    Account account;
    
    @BeforeEach
    void setUp() {
        contact = new Contact( "name",  "phoneNumber",  "email",  "companyName");
        opportunity = new Opportunity(ProductType.HYBRID, 2, Status.OPEN);
        opportunityList = new ArrayList<>(List.of(opportunity));
        account = new Account(Activity.MEDICAL, "bcn", "esp");
    }


    @Test
    void getCity_Test() {
        String res = account.getCity();
        assertEquals("bcn", res);
    }
    @Test
    void getCountry_Test() {
        String res = account.getCountry();
        assertEquals("esp", res);
    }
    @Test
    void getOpportunities_Test() {
        List<Opportunity> res = account.getOpportunities();
        assertEquals(opportunityList, res);
    }
    @Test
    void getIndustry_Test() {
        Activity res = account.getIndustry();
        assertEquals(Activity.MEDICAL, res);
    }
}
