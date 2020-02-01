package com.example.factory;

import com.example.model.BaseEntity;
import com.example.model.Book;
import com.example.model.User;
import io.micronaut.context.annotation.Factory;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Singleton;
import java.util.concurrent.Executors;

@Factory
public class ExecutorFactory {

    @Singleton
    public Scheduler executor(){
        return Schedulers.from(Executors.newSingleThreadExecutor());
    }
}
