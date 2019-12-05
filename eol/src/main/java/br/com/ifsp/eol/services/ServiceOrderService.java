package br.com.ifsp.eol.services;

import br.com.ifsp.eol.model.ServiceOrder;
import br.com.ifsp.eol.model.User;
import br.com.ifsp.eol.model.UserDTO;
import br.com.ifsp.eol.repositories.ServiceOrderRepository;
import br.com.ifsp.eol.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ServiceOrderService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public ServiceOrder save(ServiceOrder serviceOrder){
        return serviceOrderRepository.save(serviceOrder);
    }

    public List<ServiceOrder> findAll(){
        return serviceOrderRepository.findAll();
    }

    public List<ServiceOrder> findAllOsNotStarted(){
        return serviceOrderRepository.findOSNotStarted();
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

    public List<UserDTO> listarQtdOs(){
        List<UserDTO> listUserDto = new ArrayList<>();

        List<ServiceOrder> lista =  serviceOrderRepository.findOsDelayed();
        for (ServiceOrder so: lista) {
            listUserDto = contaUser(listUserDto,so.getInstaller());
        }
        return listUserDto;
    }

    public List<UserDTO> listarQtdOsDESC(){
        List<UserDTO> listUserDto = new ArrayList<>();

        List<ServiceOrder> lista =  serviceOrderRepository.findOsDelayedFinishing();
        for (ServiceOrder so: lista) {
            listUserDto = contaUser(listUserDto,so.getInstaller());
        }
        Collections.sort(listUserDto);
        return listUserDto;
    }

    private List<UserDTO> contaUser(List<UserDTO> userDTOS, User user){
        boolean achou= false;
        for(UserDTO uDTO: userDTOS){
            if(uDTO.getUser().getId() == user.getId()){
                uDTO.addAmmount();
                achou = true;
                break;
            }
        }
        if(!achou){
            UserDTO userDTO = new UserDTO(user);
            userDTO.addAmmount();
            userDTOS.add(userDTO);

        }
        return userDTOS;
    }

    public List<ServiceOrder> getMyOSnotStarted(Long id){
        return serviceOrderRepository.findOSNotStartedByInstaller(id);
    }

}
