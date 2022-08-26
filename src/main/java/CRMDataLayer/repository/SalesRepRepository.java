package CRMDataLayer.repository;

import CRMDataLayer.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {

    List<SalesRep> findByName(String name);


/* @Query("SELECT sales_rep.name, COUNT(*) as num_opportunities FROM opportunity inner JOIN sales_rep on opportunity.sales_representative = sales_rep.id GROUP BY sales_rep.name")
    List<SalesRep> findOpportunitiesBySalesRep();

 */

}
