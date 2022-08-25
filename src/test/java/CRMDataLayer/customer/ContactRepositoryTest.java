package CRMDataLayer.customer;

import CRMDataLayer.model.Contact;
import CRMDataLayer.repository.ContactRepository;
import CRMDataLayer.service.ContactService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContactRepositoryTest {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ContactService contactService;

    @BeforeEach
    void setUp() { contactRepository.deleteAll(); }

    @AfterEach
    void tearDown() { contactRepository.deleteAll(); }


    @Test
    void addNewContact() {
        Contact tester = contactRepository.save(new Contact("Rogers", "5555555555", "cap@ojsedn.com", "USA Inc."));
        Contact result1 = contactService.findByName("Rogers").get(0);
        Contact result2 = contactService.findByPhoneNumber("5555555555").get(0);
        Contact result3 = contactService.findByEmail("cap@ojsedn.com").get(0);
        Contact result4 = contactService.findByCompanyName("USA Inc.").get(0);
        assertEquals(tester.getId(), result1.getId());
        assertEquals(tester.getId(), result2.getId());
        assertEquals(tester.getId(), result3.getId());
        assertEquals(tester.getId(), result4.getId());
        assertTrue(result1.getName().equals("Rogers"));

    }



}
