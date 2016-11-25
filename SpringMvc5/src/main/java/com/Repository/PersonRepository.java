package com.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Administrator on 2016/11/18.
 */
public interface PersonRepository {

    Mono<Person> getPerson(int id);

    Flux<Person> allPeople();

    Mono<Void> savePerson(Mono<Person> person);

}
