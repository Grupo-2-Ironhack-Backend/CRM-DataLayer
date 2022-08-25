package CRMDataLayer.service;

import CRMDataLayer.model.Lead;
import CRMDataLayer.model.SalesRep;
import CRMDataLayer.repository.LeadRepository;
import CRMDataLayer.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {
    @Autowired
    LeadRepository leadRepository;
    public List<Lead> findAll()                         { return leadRepository.findAll(); }
    public List<Lead> findBySalesRep(SalesRep salesRep) { return leadRepository.findBySalesRep(salesRep); }
    public List<Lead> findByName(String name) { return leadRepository.findByName(name); }
    public List<Lead> findByPhoneNumber(String phone) { return leadRepository.findByPhoneNumber(phone); }
    public List<Lead> findByEmail(String email) { return leadRepository.findByEmail(email); }
    public List<Lead> findByCompanyName(String company) { return leadRepository.findByCompanyName(company); }
}
