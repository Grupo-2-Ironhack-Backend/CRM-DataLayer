package CRMDataLayer.repository;

import CRMDataLayer.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByName(String name);
    List<Contact> findByPhoneNumber(String phone);
    List<Contact> findByEmail(String email);
    List<Contact> findByCompanyName(String company);

}

