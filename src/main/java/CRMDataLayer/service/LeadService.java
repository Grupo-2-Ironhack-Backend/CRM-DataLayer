package CRMDataLayer.service;

import CRMDataLayer.model.Lead;
import CRMDataLayer.model.SalesRep;
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

    public Lead findById(Long id){
        if (leadRepository.findById(id).isPresent()) {
            System.out.println("NO ESTA VACIO");
            return leadRepository.findById(id).get();
        }
        System.out.println("SI ESTA VACIO");
        return null;
    }

    public Lead addNew(Lead newLead) {
        return this.leadRepository.save(newLead);
    }

    public List<Lead> findBySalesRep(SalesRep salesRep) { return leadRepository.findBySalesRep(salesRep); }
    public List<Lead> findByName(String name) { return leadRepository.findByName(name); }
    public List<Lead> findByPhoneNumber(String phone) { return leadRepository.findByPhoneNumber(phone); }
    public List<Lead> findByEmail(String email) { return leadRepository.findByEmail(email); }
    public List<Lead> findByCompanyName(String company) { return leadRepository.findByCompanyName(company); }

}
