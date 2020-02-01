package com.example.service.impl;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import io.micronaut.context.annotation.Prototype;
import io.micronaut.data.model.Pageable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Inject;

@Prototype
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Inject
    UserRepository userRepository;

    @Inject
    BCryptPasswordEncoder encoder;

    @Override
    public Single<User> save(Single<User> user) {
            return user.flatMap(u -> {
                u.setPassword(encoder.encode(u.getPassword()));
                return userRepository.save(u);
            });
    }

    @Override
    public Single<User> findById(Long id) {
        return userRepository.findById(id).switchIfEmpty(Single.error(RuntimeException::new));
    }

    @Override
    public Flowable<User> findAll(Pageable page) {
        return userRepository.findAll(page);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id).doOnComplete(()-> log.info("Deleted user with id:{}", id));
    }

    @Override
    public Single<User> update(Single<User> user) {
        return user.flatMap(userRepository::save);
    }

    @Override
    public Single<User> findByEmail(String email) {
        return userRepository.findByEmail(email).switchIfEmpty(Single.error(RuntimeException::new));
    }
}
