package customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LeadsTest {
    Leads leads;

    @BeforeEach
    void setUp() {
        leads = new Leads();
        
    }

    @Test
    @DisplayName("debe estar vacía al inicio")
    void Leads_Test() {
        assertEquals(0, leads.getLeadList().size());
    }

    @Test
    void setAndGetLeadList_Test() {
        Lead lead = new Lead("name", "phoneNumber", "email", "companyName");
        List<Lead> list = new ArrayList<>(List.of(lead));
        leads.setLeadList(list);
        assertEquals(lead, leads.getLeadList().get(0));
    }

}
