package br.com.ifsp.eol.resources;

import br.com.ifsp.eol.model.Location;
import br.com.ifsp.eol.model.ServiceOrder;
import br.com.ifsp.eol.model.User;
import br.com.ifsp.eol.services.LocationService;
import br.com.ifsp.eol.services.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("service-order")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @Autowired
    private LocationService locationService;

    @ModelAttribute
    public ServiceOrder serviceOrder(){
        return new ServiceOrder();
    }

    @GetMapping
    public String showPage(Model model) {
        return "service_order-form";
    }

    @PostMapping
    public String createServiceOrder(ServiceOrder order, @AuthenticationPrincipal User user) {
        locationService.save(order.getLocation());
        order.setClient(user);
        serviceOrderService.save(order);

        return "os-created";
    }
}
