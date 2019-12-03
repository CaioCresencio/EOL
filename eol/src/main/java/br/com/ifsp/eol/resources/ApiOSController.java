package br.com.ifsp.eol.resources;

import br.com.ifsp.eol.model.ServiceOrder;
import br.com.ifsp.eol.services.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/listaOS")
@CrossOrigin(origins = "*")
public class ApiOSController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @GetMapping
    public List<ServiceOrder> getOsNotStarted() {
        return serviceOrderService.findAllOsNotStarted();
    }

}
