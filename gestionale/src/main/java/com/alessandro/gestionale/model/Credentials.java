package com.alessandro.gestionale.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "credenziali")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="user")
    private String user;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="platform")
    private String platform;
}

