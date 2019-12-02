package br.com.ifsp.eol.resources;

import br.com.ifsp.eol.model.ServiceOrder;
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

}
