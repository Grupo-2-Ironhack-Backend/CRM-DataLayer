package CRMDataLayer.customer;

import CRMDataLayer.model.Lead;
import CRMDataLayer.model.SalesRep;
import CRMDataLayer.repository.LeadRepository;
import CRMDataLayer.repository.SalesRepRepository;
import CRMDataLayer.service.LeadService;
import CRMDataLayer.service.SalesRepService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SalesRepRepositoryTest {

    @Autowired
    SalesRepRepository salesRepRepository;
    @Autowired
    SalesRepService salesRepService;
    @Autowired
    LeadRepository leadRepository;
    @Autowired
    LeadService leadService;

    @BeforeEach
    void init() { salesRepRepository.deleteAll(); }

    @AfterEach
    void tearDown() { salesRepRepository.deleteAll();
         }

    @Test
    void addNewSalesRep() {
        SalesRep tester = salesRepRepository.save(new SalesRep("Mr.Test"));
        SalesRep result = salesRepService.findByName("Mr.Test").get(0);
        assertEquals(tester.getId(), result.getId());
        assertTrue(result.getName().equals("Mr.Test"));
    }

    @Test
    void checkRelationshipWorks() {
        SalesRep tester = salesRepRepository.save(new SalesRep("Mr.Test"));
        Lead lead1 = new Lead("Rogers", "5555555555", "cap@ojsedn.com", "USA Inc.");
        Lead lead2 = new Lead("Stark", "5555555555", "cubatas@ojsedn.com", "Extremis Foods");
        lead1.setSalesRep(tester);
        lead2.setSalesRep(tester);
        List<Lead> leadList = leadRepository.saveAll(List.of(lead1, lead2));
        tester.setLeads(leadList);
        List<Lead> leadList1 = leadService.findBySalesRep(tester);
        assertEquals(2, leadList1.size());
    }

}
