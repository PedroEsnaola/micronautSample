package com.example.config;

import com.example.model.CustomUserDetails;
import com.example.service.UserService;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class CustomAuthenticationProvider implements io.micronaut.security.authentication.AuthenticationProvider {

    @Inject
    UserService service;

    @Inject
    BCryptPasswordEncoder encoder;

    @Override
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        return service.findByEmail(authenticationRequest.getIdentity().toString()).flatMapPublisher(u -> {
            System.out.println("Founded user:" + u + "with name: "+ u.getEmail());
            if(encoder.matches(authenticationRequest.getSecret().toString(), u.getPassword())){
                return Flowable.just(new CustomUserDetails(u.getUsername(), List.of(u.getRole().toString()), u.getId()));
            }else{
                return Flowable.just(new AuthenticationFailed());
            }
        });
    }
}
