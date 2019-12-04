package br.com.ifsp.eol.resources;

import br.com.ifsp.eol.model.ServiceOrder;
import br.com.ifsp.eol.model.UserDTO;
import br.com.ifsp.eol.repositories.ServiceOrderRepository;
import br.com.ifsp.eol.services.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("list_os")
public class ListOsController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @GetMapping
    public String showPage(Model model) {
        return "list_os";
    }

    @ModelAttribute
    public void fillListOs(Model model) {
        model.addAttribute("OS",serviceOrderService.findAll());
    }

    @RequestMapping("getListas")
    public @ResponseBody List<ServiceOrder> listar(Model model) {
        return serviceOrderService.findAll();
    }

    @RequestMapping("getOsDelayed")
    public @ResponseBody List<ServiceOrder> listOsDelayed(Model model) {
        return serviceOrderRepository.findOsDelayed();
    }

    @RequestMapping("getUserDto")
    public @ResponseBody List<UserDTO> listDtoDelayed(Model model){
        return serviceOrderService.listarQtdOs();
    }
    @RequestMapping("getFinishOsDESC")
    public @ResponseBody List<UserDTO> listDtoDelayedDESC(Model model){
        return serviceOrderService.listarQtdOsDESC();
    }



   /* @RequestMapping("getUserDto")
    public @ResponseBody List<UserDTO> listDtoDelayed(Model model){
        return serviceOrderRepository.findFinishOs();
    }

    @RequestMapping("getFinishOsDESC")
    public @ResponseBody List<UserDTO> userDTOList(Model model){
        return serviceOrderRepository.findFinishOsDESC();
    }*/




}
