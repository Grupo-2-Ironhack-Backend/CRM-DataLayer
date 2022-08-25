package CRMDataLayer.customer;

import CRMDataLayer.enums.ProductType;
import CRMDataLayer.enums.Status;
import CRMDataLayer.model.*;
import CRMDataLayer.repository.AccountRepository;
import CRMDataLayer.repository.ContactRepository;
import CRMDataLayer.repository.OpportunityRepository;
import CRMDataLayer.repository.SalesRepRepository;
import CRMDataLayer.service.OpportunityService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static CRMDataLayer.enums.Activity.MEDICAL;
import static CRMDataLayer.enums.ProductType.HYBRID;
import static CRMDataLayer.enums.Status.OPEN;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OpportunityRepositoryTest {

    @Autowired
    OpportunityRepository opportunityRepository;
    @Autowired
    OpportunityService opportunityService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    SalesRepRepository salesRepRepository;

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
        Opportunity tester = opportunityRepository.save(new Opportunity(HYBRID, 2, OPEN));
        Opportunity result1 = opportunityService.findByProductType(HYBRID).get(0);
        Opportunity result2 = opportunityService.findByNumberOfTrucks(2).get(0);
        Opportunity result3 = opportunityService.findByStatus(OPEN).get(0);
        assertEquals(tester.getId(), result1.getId());
        assertEquals(tester.getId(), result2.getId());
        assertEquals(tester.getId(), result3.getId());
        assertTrue(result1.getProductType().equals(HYBRID));
    }

    @Test
    void checkRelationshipWorks() {
        Opportunity tester = new Opportunity(HYBRID, 2, OPEN);
        Contact decisionMaker = contactRepository.save(new Contact("Rogers", "5555555555", "cap@ojsedn.com", "USA Inc."));
        SalesRep salesRep = salesRepRepository.save(new SalesRep("Mr.Test"));
        Account account = accountRepository.save(new Account( MEDICAL, "Gargantilla del Lozoya y Pinilla de Buitrago", "Spain"));

        tester.setDecisionMaker(decisionMaker);
        tester.setSalesRep(salesRep);
        tester.setAccount(account);
        opportunityRepository.save(tester);
        assertEquals(opportunityService.findByDecisionMaker(decisionMaker).get().getId(), tester.getId());
        assertEquals(opportunityService.findBySalesRep(salesRep).get().getId(), tester.getId());
        assertEquals(opportunityService.findByAccount(account).get().getId(), tester.getId());
    }



}
