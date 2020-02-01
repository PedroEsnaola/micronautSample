package com.example.service;

import com.example.model.User;
import io.micronaut.data.model.Pageable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public interface UserService {

    Single<User> save(Single<User> user);

    Single<User> findById(Long id);

    Flowable<User> findAll(Pageable page);

    void deleteById(Long id);

    Single<User> update(Single<User> user);

    Single<User> findByEmail(String email);
}
