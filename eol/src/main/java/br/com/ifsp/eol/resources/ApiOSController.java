package br.com.ifsp.eol.resources;

import br.com.ifsp.eol.model.ServiceOrder;
import br.com.ifsp.eol.model.User;
import br.com.ifsp.eol.services.ServiceOrderService;
import br.com.ifsp.eol.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listaOS")
@CrossOrigin(origins = "*")
public class ApiOSController {

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceOrderService serviceOrderService;

    @GetMapping
    public List<ServiceOrder> getOsNotStarted() {
        return serviceOrderService.findAllOsNotStarted();
    }

    @PostMapping("/{id}")
    public ServiceOrder attribui(@PathVariable("id") Long id_OS, @RequestBody Long id_installer){
        User installer = userService.findById(id_installer);
        ServiceOrder os = serviceOrderService.findById(id_OS);

        return serviceOrderService.attribui(os, installer);
    }

    @PostMapping("/finalizar/{id}")
    public ServiceOrder finalizar(@PathVariable Long id_OS){
        ServiceOrder os = serviceOrderService.findById(id_OS);

        return serviceOrderService.finalizar(os);
    }

}
