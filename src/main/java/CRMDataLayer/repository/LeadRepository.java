package CRMDataLayer.repository;

import CRMDataLayer.model.Lead;
import CRMDataLayer.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

    List<Lead> findBySalesRep(SalesRep salesRep);
    List<Lead> findByName(String name);
    List<Lead> findByPhoneNumber(String phone);
    List<Lead> findByEmail(String email);
    List<Lead> findByCompanyName(String company);

}
