package br.com.ifsp.eol.resources;

import br.com.ifsp.eol.model.*;
import br.com.ifsp.eol.security.JWTUtil;
import br.com.ifsp.eol.services.ServiceOrderService;
import br.com.ifsp.eol.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiOSController {

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceOrderService serviceOrderService;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/listaOS")
    public List<ServiceOrder> getOsNotStarted() {
        return serviceOrderService.findAllOsNotStarted();
    }

    @GetMapping("/listaOS/{id}")
    public List<ServiceOrder> getMyOs(@PathVariable("id") Long id) {
        return serviceOrderService.getMyOSnotStarted(id);
    }

    @PostMapping("/atribuir")
    public ServiceOrder atribuir(@RequestBody AtribuiReqDTO reqDTO){
        User installer = userService.findById(reqDTO.getId_installer());
        ServiceOrder os = serviceOrderService.findById(reqDTO.getId_serviceOrder());

        return serviceOrderService.attribui(os, installer);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ServiceOrder finalizar(@PathVariable("id") Long id){
        ServiceOrder os = serviceOrderService.findById(id);

        return serviceOrderService.finalizar(os);
    }

    @PostMapping("/login")
    public UserToken login(@RequestBody CredenciaisDTO credenciaisDTO) {
        UserToken user = new UserToken();
        if(credenciaisDTO != null && credenciaisDTO.getEmail() != null && credenciaisDTO.getPassword() != null) {
            user.setUser(userService.verificaLogin(credenciaisDTO.getEmail(), credenciaisDTO.getPassword()));
            user.setToken(jwtUtil.generateToken(credenciaisDTO.getEmail()));
        }
        return user;
    }

}
