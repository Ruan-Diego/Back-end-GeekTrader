package com.geek.trader.controllers;

import com.geek.trader.domain.user.AuthenticationDTO;
import com.geek.trader.domain.user.LoginResponseDTO;
import com.geek.trader.domain.user.User;
import com.geek.trader.infra.security.TokenService;
import com.geek.trader.repositories.UserRepository;
import com.geek.trader.services.LoginService;
import com.geek.trader.services.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RegisterService registerService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        return loginService.login(data);
    }

    @PostMapping("/register")
    public  ResponseEntity register(@RequestBody @Valid AuthenticationDTO data) {
        return registerService.register(data);
    }
}
