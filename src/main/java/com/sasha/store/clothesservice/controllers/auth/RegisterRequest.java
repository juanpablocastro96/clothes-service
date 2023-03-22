package com.sasha.store.clothesservice.controllers.auth;


import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class RegisterRequest extends AuthenticationRequest {

    private String firstname;
    private String lastname;

    public RegisterRequest(String email, String password) {
        super(email, password);
    }
}
