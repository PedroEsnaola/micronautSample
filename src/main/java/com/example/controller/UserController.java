package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Single;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;


@Controller("/user")
@Secured(SecurityRule.IS_AUTHENTICATED)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService service;

    @Inject
    Scheduler scheduler;

    @Post
    @PermitAll
    public Single<User> save(@Body @Valid Single<User> user){
        return service.save(user);
    }

    @Get()
    @Secured({"ROLE_ADMIN"})
    public Flowable<User> findAll(@QueryValue int page, @QueryValue int size){
        return service.findAll(Pageable.from(page, size)).subscribeOn(scheduler);
    }




}
