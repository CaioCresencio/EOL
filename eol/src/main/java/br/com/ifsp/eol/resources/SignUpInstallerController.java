package br.com.ifsp.eol.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sign_up_installer")
public class SignUpInstallerController {

    @GetMapping
    private String showPage(Model model){
        return "sign_up_installer";
    }
}
