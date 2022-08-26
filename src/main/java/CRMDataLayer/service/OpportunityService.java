package CRMDataLayer.service;

import CRMDataLayer.enums.ProductType;
import CRMDataLayer.enums.Status;
import CRMDataLayer.model.Account;
import CRMDataLayer.model.Contact;
import CRMDataLayer.model.Opportunity;
import CRMDataLayer.model.SalesRep;
import CRMDataLayer.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OpportunityService {

    @Autowired
    OpportunityRepository opportunityRepository;

    public List<Opportunity> findByProductType(ProductType productType) {
        return opportunityRepository.findByProductType(productType);
    }

    public List<Opportunity> findByNumberOfTrucks(int numberOfTrucks) {
        return opportunityRepository.findByNumberOfTrucks(numberOfTrucks);
    }

    public List<Opportunity> findByStatus(Status status) {
        return opportunityRepository.findByStatus(status);
    }

    public Optional<Opportunity> findByDecisionMaker(Contact decisionMaker) {
        return opportunityRepository.findByDecisionMaker(decisionMaker);
    }

    public Optional<Opportunity> findBySalesRep(SalesRep salesRep) {
        return opportunityRepository.findBySalesRep(salesRep);
    }

    public Optional<Opportunity> findByAccount(Account account) {
        return opportunityRepository.findByAccount(account);
    }
}
