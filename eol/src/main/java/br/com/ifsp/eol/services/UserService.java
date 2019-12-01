package br.com.ifsp.eol.services;

import br.com.ifsp.eol.model.User;
import br.com.ifsp.eol.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User save(User user){
        return repo.save(user);
    }
}
