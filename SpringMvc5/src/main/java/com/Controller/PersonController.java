package com.Controller;

import com.Repository.Person;
import com.Repository.PersonRepository;

import org.reactivestreams.Publisher;
import org.springframework.web.reactive.function.ServerRequest;
import org.springframework.web.reactive.function.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Administrator on 2016/11/18.
 */
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository){
        this.repository = repository;
    }

    ServerResponse<Publisher<Person>> getPerson(ServerRequest request){
        int personId = Integer.valueOf(request.pathVariable("id"));

        Mono<Person> person = this.repository.getPerson(personId);
        return ServerResponse.ok().body(person,Person.class);
    }


    public ServerResponse<Mono<Void>> createPerson(ServerRequest request) {
        Mono<Person> person = request.bodyToMono(Person.class);
        return ServerResponse.ok().build(this.repository.savePerson(person));
    }

    public ServerResponse<Publisher<Person>> listPeople(ServerRequest request) {
        Flux<Person> people = this.repository.allPeople();
        return ServerResponse.ok().body(people, Person.class);
    }
}
