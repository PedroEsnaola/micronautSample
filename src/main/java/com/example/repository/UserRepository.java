package com.example.repository;

import com.example.model.User;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.reactive.RxJavaCrudRepository;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface UserRepository extends RxJavaCrudRepository<User, Long> {

    Flowable<User> findAll(Pageable page);

    Maybe<User> findByEmail(String email);

}
