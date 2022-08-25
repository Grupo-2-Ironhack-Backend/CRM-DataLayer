package CRMDataLayer.customer;

import CRMDataLayer.enums.ProductType;
import CRMDataLayer.enums.Status;
import CRMDataLayer.model.Contact;
import CRMDataLayer.model.Opportunity;
import CRMDataLayer.repository.OpportunityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OpportunityRepositoryTest {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @BeforeEach
    void setUp() {
        opportunityRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
    }

    @Test
    void addNewOpportunityTest() {
        Contact contact = new Contact("name", "phoneNumber", "email", "companyName");
        Opportunity opportunity = new Opportunity(ProductType.HYBRID, 2, Status.OPEN);
    }

}
