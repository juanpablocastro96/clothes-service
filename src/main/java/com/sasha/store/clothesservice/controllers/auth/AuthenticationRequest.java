package com.sasha.store.clothesservice.controllers.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationRequest {
    protected String email;
    protected String password;
}
