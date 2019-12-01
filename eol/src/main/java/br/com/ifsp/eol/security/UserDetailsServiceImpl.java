package br.com.ifsp.eol.security;

import br.com.ifsp.eol.model.User;
import br.com.ifsp.eol.repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger =
            LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);


        if (user == null) {
            throw new UsernameNotFoundException(
                    "Username " + email + " não encontrado.");
        }

        if (user.getAuthorities().size() == 0) {
            throw new UsernameNotFoundException(
                    "Username " + email + ": sem papéis (roles) cadastrados.");
        }

        return user;
    }
}
