package CRMDataLayer.service;

import CRMDataLayer.model.SalesRep;
import CRMDataLayer.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesRepService {

    @Autowired
    SalesRepRepository salesRepRepository;

    public SalesRep findBySalesRepId(Long id){
        if (salesRepRepository.findById(id).isPresent())
            return salesRepRepository.findById(id).get();
        return null;
    }

    public List<SalesRep> findAll(){
        return salesRepRepository.findAll();
    }


}
