package br.com.ifsp.eol.resources;

import br.com.ifsp.eol.model.User;
import br.com.ifsp.eol.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign_up")
public class SignUpController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder pe;

    @GetMapping
    public String showPage(Model model) {
        return "sign_up";
    }

    @PostMapping
    public String singUp(User user) {
        //Papel papel = new Papel("ROLE_USER");
        //user.addPapel(papel);
        userService.save(user);
        return "redirect:/";
    }

}
