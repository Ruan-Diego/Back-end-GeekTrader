package com.geek.trader.services;

import com.geek.trader.domain.user.AuthenticationDTO;
import com.geek.trader.domain.user.User;
import com.geek.trader.domain.user.UserDTO;
import com.geek.trader.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.geek.trader.domain.user.UserDTO.convertListToDto;
import static com.geek.trader.domain.user.UserDTO.convertToDto;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserDTO userDTO;


    public ResponseEntity<List<UserDTO>> getAll(){
        List<User> List = repository.findAll();
        List<UserDTO> dtoList = convertListToDto(List);

        if(dtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    public ResponseEntity<UserDTO> get(String id){
        Optional<User> optionalUser = repository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new ResponseEntity<>(convertToDto(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public UserDTO update(User user, String id){
        Optional<User> op = repository.findById(id);
        if (op.isPresent()) {
            User obj = op.get();
            if(user.getLogin() != null){
                obj.setLogin(user.getLogin());
            }
            if(user.getPassword() != null){
                obj.setPassword(user.getPassword());
            }
            repository.save(obj);
            return userDTO.convertToDto(obj);
        }
        return null;
    }

    public ResponseEntity delete(String user){
        if(repository.existsById(user)){
            this.repository.deleteById(user);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
