package CRMDataLayer.service;

import CRMDataLayer.model.Lead;
import CRMDataLayer.model.SalesRep;
import CRMDataLayer.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesRepService {

    @Autowired
    SalesRepRepository salesRepRepository;

    public List<SalesRep> findByName(String name) {
        return salesRepRepository.findByName(name);
    }

    public List<SalesRep> findAll() {
        return salesRepRepository.findAll();
    }


}
