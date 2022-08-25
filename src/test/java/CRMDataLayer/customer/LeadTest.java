package CRMDataLayer.customer;

import CRMDataLayer.model.Lead;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class LeadTest {
    Lead lead;

    @BeforeEach
    void setUp() {
        lead = new Lead("name", "phoneNumber", "email", "companyName");
    }

    @Test
    void getCompanyName_Test() {
        String res = lead.getCompanyName();
        assertEquals("companyName", res);
    }

    @Test
    void getEmail_Test() {
        String res = lead.getEmail();
        assertEquals("email", res);
    }

    @Test
    void getPhoneNumber_Test() {
        String res = lead.getPhoneNumber();
        assertEquals("phoneNumber", res);
    }

    @Test
    void getName_Test() {
        String res = lead.getName();
        assertEquals("name", res);
    }

    @Test
    void getId_Test() {
        UUID res = lead.getId();
        assertEquals(UUID.class, res.getClass());
    }
}
