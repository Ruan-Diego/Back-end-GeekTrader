package com.geek.trader.services;


import com.geek.trader.domain.user.AuthenticationDTO;
import com.geek.trader.domain.user.LoginResponseDTO;
import com.geek.trader.domain.user.User;
import com.geek.trader.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    public ResponseEntity login(AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken((data.login()), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
