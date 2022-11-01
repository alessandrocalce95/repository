package com.alessandro.gestionale.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "credentials")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="USERNAME")
    private String username;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="PLATFORM")
    private String platform;
}

