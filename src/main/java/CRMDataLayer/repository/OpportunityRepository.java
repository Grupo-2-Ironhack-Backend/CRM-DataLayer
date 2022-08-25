package CRMDataLayer.repository;

import CRMDataLayer.enums.ProductType;
import CRMDataLayer.enums.Status;
import CRMDataLayer.model.Account;
import CRMDataLayer.model.Contact;
import CRMDataLayer.model.Opportunity;
import CRMDataLayer.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    List<Opportunity> findByProductType(ProductType productType);

    List<Opportunity> findByNumberOfTrucks(int numberOfTrucks);

    List<Opportunity> findByStatus(Status status);

    Optional<Opportunity> findByDecisionMaker(Contact decisionMaker);

    Optional<Opportunity> findBySalesRep(SalesRep salesRep);

    Optional<Opportunity> findByAccount(Account account);
}
