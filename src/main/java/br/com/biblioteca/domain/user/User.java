package br.com.biblioteca.domain.user;

import br.com.biblioteca.core.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_users")
public class User extends BaseEntity {

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String imageUrl;

    @Column(unique = true)
    private String cpf;

    @NotBlank
    @Email
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Column(nullable = false)
    private String number;

    @NotBlank
    @Column(nullable = false)
    private String countryCode;

    public User() {
    }

    public User(String name, String imageUrl, String cpf, String email, Role role, String password, String number, String countryCode) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.cpf = cpf;
        this.email = email;
        this.role = role;
        this.password = password;
        this.number = number;
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}