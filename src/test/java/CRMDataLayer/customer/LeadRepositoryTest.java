package CRMDataLayer.customer;

import CRMDataLayer.model.Lead;
import CRMDataLayer.model.SalesRep;
import CRMDataLayer.repository.LeadRepository;
import CRMDataLayer.repository.SalesRepRepository;
import CRMDataLayer.service.LeadService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class LeadRepositoryTest {

    @Autowired
    LeadRepository leadRepository;

    @Autowired
    LeadService leadService;

    @Autowired
    SalesRepRepository salesRepRepository;

    @BeforeEach
    void setUp() { leadRepository.deleteAll(); }

    @AfterEach
    void tearDown() { leadRepository.deleteAll(); }


    @Test
    void addNewLead() {
        Lead tester = leadRepository.save(new Lead("Rogers", "5555555555", "cap@ojsedn.com", "USA Inc."));
        Lead result1 = leadService.findByName("Rogers").get(0);
        Lead result2 = leadService.findByPhoneNumber("5555555555").get(0);
        Lead result3 = leadService.findByEmail("cap@ojsedn.com").get(0);
        Lead result4 = leadService.findByCompanyName("USA Inc.").get(0);
        assertEquals(tester.getId(), result1.getId());
        assertEquals(tester.getId(), result2.getId());
        assertEquals(tester.getId(), result3.getId());
        assertEquals(tester.getId(), result4.getId());
        assertTrue(result1.getName().equals("Rogers"));
    }

    @Test
    void checkRelationshipWorks() {
        Lead tester1 = new Lead("Rogers", "5555555555", "cap@ojsedn.com", "USA Inc.");
        Lead tester2 = new Lead("Stark", "5555555555", "cubatas@ojsedn.com", "Extremis Foods");
        SalesRep salesRep = salesRepRepository.save(new SalesRep("Mr.Test"));
        tester1.setSalesRep(salesRep);
        tester2.setSalesRep(salesRep);
        List<Lead> leadList = leadRepository.saveAll(List.of(tester1, tester2));
        salesRep.setLeads(leadList);
        List<Lead> leadList1 = leadService.findBySalesRep(salesRep);
        assertEquals(2, leadList1.size());
    }

}
