package customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("name", "phoneNumber", "email", "companyName");
    }

    @Test
    void getCompanyName_Test() {
        String res = contact.getCompanyName();
        assertEquals("companyName", res);
    }

    @Test
    void getEmail_Test() {
        String res = contact.getEmail();
        assertEquals("email", res);
    }

    @Test
    void getPhoneNumber_Test() {
        String res = contact.getPhoneNumber();
        assertEquals("phoneNumber", res);
    }

    @Test
    void getName_Test() {
        String res = contact.getName();
        assertEquals("name", res);
    }

    @Test
    void getId_Test() {
        UUID res = contact.getId();
        assertEquals(UUID.class, res.getClass());
    }
}
