package customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OpportunityTest {
    Contact contact;
    Opportunity opportunity;
    
    @BeforeEach
    void setUp() {
        contact = new Contact( "name",  "phoneNumber",  "email",  "companyName");
        opportunity = new Opportunity(contact, ProductType.HYBRID, 2, Status.OPEN);
    }


    @Test
    void getCity_Test() {
        Status res = opportunity.getStatus();
        assertEquals(Status.OPEN, res);
    }
    @Test
    void getNumberOfTrucks_Test() {
        int res = opportunity.getNumberOfTrucks();
        assertEquals(2, res);
    }
    @Test
    void getOpportunities_Test() {
        ProductType res = opportunity.getProductType();
        assertEquals(ProductType.HYBRID, res);
    }
    @Test
    void getIndustry_Test() {
        Contact res = opportunity.getDecisionMaker();
        assertEquals(contact, res);
    }
}
