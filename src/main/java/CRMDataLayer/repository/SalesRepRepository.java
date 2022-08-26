package CRMDataLayer.repository;

import CRMDataLayer.model.Lead;
import CRMDataLayer.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {

    Optional<SalesRep> findById(Long id);
    /*
    @Query("SELECT sales_rep.name, COUNT(*) as num_lead FROM _lead inner JOIN sales_rep on _lead.sales_rep = sales_rep.id GROUP BY sales_rep.name")
    List<SalesRep> findLeadBySalesRepGroup();

    @Query("SELECT sales_rep.name, COUNT(*) as num_opportunities FROM opportunity inner JOIN sales_rep on opportunity.sales_representative = sales_rep.id GROUP BY sales_rep.name")
    List<SalesRep> findOpportunitiesBySalesRep();

    @Query("SELECT sales_rep.name, COUNT(*) as num_opportunities FROM opportunity inner JOIN sales_rep on opportunity.sales_representative = sales_rep.id GROUP BY sales_rep.name")
    List<SalesRep> findClosedWonBySalesRep();*/

}
