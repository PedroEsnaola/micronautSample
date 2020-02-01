package com.example.factory;

import io.micronaut.context.annotation.Factory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Singleton;

@Factory
public class PasswordEncoderFactory {

    @Singleton
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
