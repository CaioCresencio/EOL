package br.com.ifsp.eol.services;

import br.com.ifsp.eol.model.User;
import br.com.ifsp.eol.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder pe;

    public User save(User user){
        user.setPassword(pe.encode(user.getPassword()));

        return repo.save(user);
    }

    public User findById(Long id_installer) {
        return repo.findById(id_installer).get();
    }

    public static User authenticated() {
        try {
            return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        catch (Exception e) {
            return null;
        }
    }
}
