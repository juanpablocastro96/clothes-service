package com.sasha.store.clothesservice.controllers.auth;


import lombok.Builder;

import lombok.Getter;


@Getter
public class RegisterRequest extends AuthenticationRequest {

    private final String firstname;
    private final String lastname;

    @Builder
    public RegisterRequest(String email, String password, String firstname, String lastname) {
        super(email, password);
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
