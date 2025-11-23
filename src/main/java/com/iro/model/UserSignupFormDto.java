package com.iro.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupFormDto {
    private String username;
    private String email;
    private String password;
}
