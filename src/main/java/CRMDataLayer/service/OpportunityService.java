package CRMDataLayer.service;

import CRMDataLayer.enums.ProductType;
import CRMDataLayer.enums.Status;
import CRMDataLayer.model.*;
import CRMDataLayer.repository.ContactRepository;
import CRMDataLayer.repository.LeadRepository;
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

    @Autowired
    LeadRepository leadRepository;
    @Autowired
    ContactRepository contactRepository;

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

    public void createFromLeadId(Long leadId, ProductType product, int quantity) {
        Optional<Lead> lead = leadRepository.findById(leadId);
        if (lead.isPresent()) {
            Contact contact = new Contact(
                    lead.get().getName(),
                    lead.get().getPhoneNumber(),
                    lead.get().getEmail(),
                    lead.get().getCompanyName()
            );
            Contact contactBD = contactRepository.save(contact);
            Opportunity opportunity = new Opportunity();
            opportunity.setSalesRep(lead.get().getSalesRep());
            opportunity.setDecisionMaker(contactBD);
            opportunity.setStatus(Status.OPEN);
            opportunity.setProductType(product);
            opportunity.setNumberOfTrucks(quantity);
            opportunityRepository.save(opportunity);
        } else {
            System.out.println("\nlead not found.\n");
        }
    }
}
