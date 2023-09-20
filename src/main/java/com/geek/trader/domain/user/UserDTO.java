package com.geek.trader.domain.user;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserDTO {
    private String id;
    private String login;
    private String password;


    public UserDTO(String login, String password){
        this.login = login;
        this.password = password;
    }
    public UserDTO() {
    }
    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserDTO convertToDto(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setLogin(user.getLogin());
        dto.setPassword(user.getPassword());
        return dto;
    }
    public static List<UserDTO> convertListToDto(List<User> users) {
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
