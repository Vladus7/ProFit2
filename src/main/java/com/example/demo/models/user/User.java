package com.example.demo.models.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
    private String role;
    private String email;
    private LocalDate birthday;

    public User() {
    }

    public User(String name, String password, String role, String email, LocalDate birthday) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
        this.birthday = birthday;
    }

    public User(long id, String name, String password, String role, String email, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
        this.birthday = birthday;
    }
}
