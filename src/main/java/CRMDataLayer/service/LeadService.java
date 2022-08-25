package CRMDataLayer.service;

import CRMDataLayer.model.Lead;
import CRMDataLayer.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {
    @Autowired
    LeadRepository leadRepository;
    public List<Lead> findAll() {
        if (leadRepository.findAll().isEmpty()) {
            System.out.println("no results found");
        } else {
            return leadRepository.findAll();
        }
        return null;
    }

    public Lead addNew(Lead newLead) {
        return this.leadRepository.save(newLead);
    }
}
