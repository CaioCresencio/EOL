package br.com.ifsp.eol.services;

import br.com.ifsp.eol.model.ServiceOrder;
import br.com.ifsp.eol.repositories.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public ServiceOrder save(ServiceOrder serviceOrder){
        return serviceOrderRepository.save(serviceOrder);
    }
}
