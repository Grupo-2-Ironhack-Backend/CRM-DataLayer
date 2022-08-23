package CRMDataLayer.service;

import CRMDataLayer.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpportunityService {

    @Autowired
    OpportunityRepository opportunityRepository;
}
