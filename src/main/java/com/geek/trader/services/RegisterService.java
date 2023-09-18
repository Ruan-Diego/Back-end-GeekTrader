package com.geek.trader.services;

import com.geek.trader.domain.user.AuthenticationDTO;
import com.geek.trader.domain.user.User;
import com.geek.trader.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    UserRepository repository;
    public ResponseEntity register(AuthenticationDTO data){
        if(this.repository.findByLogin(data.login()) != null)
            return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode((data.password()));
        User newUser = new User(data.login(), encryptedPassword);

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
