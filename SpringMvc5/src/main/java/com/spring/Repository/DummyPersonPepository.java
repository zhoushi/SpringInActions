package com.spring.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/18.
 */
public class DummyPersonPepository implements PersonRepository {

    private final Map<Integer,Person> personMap = new HashMap<>();

    public DummyPersonPepository(){
        this.personMap.put(1,new Person("zhou",42));
        this.personMap.put(1,new Person("shi",36));

    }
    @Override
    public Mono<Person> getPerson(int id) {
        return Mono.justOrEmpty(this.personMap.get(id));
    }

    @Override
    public Flux<Person> allPeople() {
        return Flux.fromIterable(this.personMap.values());
    }

    @Override
    public Mono<Void> savePerson(Mono<Person> person) {
        return person.then(
                person1 -> {
                    int id = personMap.size() + 1;
                    personMap.put(id,person1);
                    System.out.format("Saved %s with id %d%n", person, id);
                    return Mono.empty();
                });
    }
}
