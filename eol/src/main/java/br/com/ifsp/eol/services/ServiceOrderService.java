package br.com.ifsp.eol.services;

import br.com.ifsp.eol.model.ServiceOrder;
import br.com.ifsp.eol.model.User;
import br.com.ifsp.eol.repositories.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public ServiceOrder save(ServiceOrder serviceOrder){
        return serviceOrderRepository.save(serviceOrder);
    }

    public List<ServiceOrder> findAll(){
        return serviceOrderRepository.findAll();
    }

    public List<ServiceOrder> findAllOsNotStarted(){
        return serviceOrderRepository.findAll();
    }

    public ServiceOrder findById(Long id_os) {
        return serviceOrderRepository.findById(id_os).get();
    }

    public ServiceOrder attribui(ServiceOrder os, User installer) {
        os.setInstaller(installer);
        os.setAssignment_date(LocalDate.now());

        return serviceOrderRepository.save(os);
    }

    public ServiceOrder finalizar(ServiceOrder os) {
        os.setFinishing_date(LocalDate.now());

        return serviceOrderRepository.save(os);
    }
}
