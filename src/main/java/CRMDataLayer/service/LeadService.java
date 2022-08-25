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
        return leadRepository.findAll();
    }
}
