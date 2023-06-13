package com.example231.crud.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class UserDTO {
    private Long id;
    private java.lang.String username;
    private java.lang.String lastname;
    @NotNull(message = "поле не может быть пустым")
    @Min(value = 1, message = "возраст должен быть больше 1 года")
    @Max(value = 130, message = "возраст должен быть меньше 130 лет")
    private Integer age;
    @Email(message = "не валидный email")
    private String email;
    private String password;
    private List<String> roles;
    private String avatar;

    private String postalAddress;
    private Double[] coords;

    public UserDTO() {

    }

    public UserDTO(Long id, String username, String lastname, Integer age, String email,
                   String password, List<String> roles, String avatar, Double[] coords) {
        this.id = id;
        this.username = username;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.avatar = avatar;
        this.coords = coords;
    }

    public UserDTO(Long id, String username, String lastname, Integer age, String email,
                   String password, List<String> roles, String avatar, String postalAddress) {
        this.id = id;
        this.username = username;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.avatar = avatar;
        this.postalAddress = postalAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }
    public Double[] getCoords() {
        return coords;
    }

    public void setCoords(Double[] coords) {
        this.coords = coords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
