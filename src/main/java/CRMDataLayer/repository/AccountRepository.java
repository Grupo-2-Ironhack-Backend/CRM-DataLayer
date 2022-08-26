package CRMDataLayer.repository;

import CRMDataLayer.enums.Activity;
import CRMDataLayer.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByIndustry(Activity industry);

    List<Account> findByCity(String city);

    List<Account> findByCountry(String country);

}
