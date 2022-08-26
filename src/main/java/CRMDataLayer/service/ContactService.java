package CRMDataLayer.service;

import CRMDataLayer.model.Contact;
import CRMDataLayer.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    public List<Contact> findByName(String name) {
        return contactRepository.findByName(name);
    }

    public List<Contact> findByPhoneNumber(String phone) {
        return contactRepository.findByPhoneNumber(phone);
    }

    public List<Contact> findByEmail(String email) {
        return contactRepository.findByEmail(email);
    }

    public List<Contact> findByCompanyName(String company) {
        return contactRepository.findByCompanyName(company);
    }
}
