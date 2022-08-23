package CRMDataLayer.service;

import CRMDataLayer.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadService {

    @Autowired
    LeadRepository leadRepository;
}
