package CRMDataLayer.service;

import CRMDataLayer.enums.Activity;
import CRMDataLayer.model.Account;
import CRMDataLayer.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> findByIndustry(Activity industry) {
        return accountRepository.findByIndustry(industry);
    }


    public List<Account> findByCity(String city) {
        return accountRepository.findByCity(city);
    }

    public List<Account> findByCountry(String country) {
        return accountRepository.findByCountry(country);
    }


}
