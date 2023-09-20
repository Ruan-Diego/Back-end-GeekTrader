package com.geek.trader.controllers;

import com.geek.trader.domain.user.AuthenticationDTO;
import com.geek.trader.domain.user.User;
import com.geek.trader.domain.user.UserDTO;
import com.geek.trader.services.UserService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> get(@PathVariable String id){
        return userService.get(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAll(){
        return userService.getAll();
    }

    @PutMapping("/{id}")
    public UserDTO update(@RequestBody User user, @PathVariable("id") String id){
        return userService.update(user, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id){
        return userService.delete(id);
    }

}
