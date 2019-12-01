package br.com.ifsp.eol.resources;

import br.com.ifsp.eol.model.User;
import br.com.ifsp.eol.model.enums.Role;
import br.com.ifsp.eol.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sign_up_installer")
public class SignUpInstallerController {

    @Autowired
    private UserService userService;

    @GetMapping
    private String showPage(Model model){
        return "sign_up_installer";
    }

    @PostMapping
    public String singUp(User user) {
        user.addRole(Role.INSTALLER);
        userService.save(user);
        return "redirect:/";
    }
}
