package CRMDataLayer.service;

import CRMDataLayer.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesRepService {

    @Autowired
    SalesRepRepository salesRepRepository;
}
