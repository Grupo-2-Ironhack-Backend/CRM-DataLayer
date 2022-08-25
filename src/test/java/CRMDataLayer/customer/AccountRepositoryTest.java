package CRMDataLayer.customer;

import CRMDataLayer.enums.Activity;
import CRMDataLayer.enums.ProductType;
import CRMDataLayer.enums.Status;
import CRMDataLayer.model.*;
import CRMDataLayer.repository.AccountRepository;
import CRMDataLayer.repository.ContactRepository;
import CRMDataLayer.repository.OpportunityRepository;
import CRMDataLayer.service.AccountService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    OpportunityRepository opportunityRepository;

    
    @BeforeEach
    void setUp() { accountRepository.deleteAll(); }


    @AfterEach
    void tearDown() { accountRepository.deleteAll(); }

    @Test
    void addNewAccountTest() {
        Account tester = accountRepository.save(new Account(Activity.MEDICAL, "Gargantilla del Lozoya y Pinilla de Buitrago", "Spain"));
        Account result1 = accountService.findByIndustry(Activity.MEDICAL).get(0);
        Account result2 = accountService.findByCity("Gargantilla del Lozoya y Pinilla de Buitrago").get(0);
        Account result3 = accountService.findByCountry("Spain").get(0);
        assertEquals(tester.getId(), result1.getId());
        assertEquals(tester.getId(), result2.getId());
        assertEquals(tester.getId(), result3.getId());
        assertTrue(result1.getIndustry().equals(Activity.MEDICAL));
    }

    @Test
    void checkRelationshipWorks() {
        Account tester = new Account(Activity.MEDICAL, "Gargantilla del Lozoya y Pinilla de Buitrago", "Spain");
        Contact contact1 = new Contact("Rogers", "5555555555", "cap@ojsedn.com", "USA Inc.");
        Contact contact2 = new Contact("Stark", "5555855555", "cubatas@ojsedn.com", "Extremis Foods");
        Opportunity opportunity1 = new Opportunity(ProductType.HYBRID, 2, Status.OPEN);
        Opportunity opportunity2 = new Opportunity(ProductType.FLATBED, 5, Status.CLOSED_LOST);
        System.out.println("FLAG 1");
        contact1.setAccount(tester);
        contact2.setAccount(tester);
        System.out.println("FLAG 2");
        List<Contact> contacts = contactRepository.saveAll(List.of(contact1, contact2));
        opportunity1.setAccount(tester);
        opportunity2.setAccount(tester);
        System.out.println("FLAG 3");
        List<Opportunity> opportunities = opportunityRepository.saveAll(List.of(opportunity1, opportunity2));
        tester.setContacts(contacts);
        tester.setOpportunities(opportunities);
        System.out.println("FLAG 4");
        Account result = accountRepository.save(tester);
        assertEquals(result.getContacts().size(), 2);
        // assertEquals(result.getOpportunities().size(), 2);
    }
}
