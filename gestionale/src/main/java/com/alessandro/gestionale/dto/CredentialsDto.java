package com.alessandro.gestionale.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CredentialsDto {

    private String username;
    private String email;
    private String password;
    private String platform;

}

