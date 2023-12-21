package com.cinchhs.batchprocessdemo;

import com.cinchhs.batchprocessdemo.domain.Person;
import org.springframework.batch.item.ItemProcessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person, Person> {
    @Override
    public Person process(Person person) throws Exception {
        Person transformedPerson = Person.builder().firstName(person.firstName().toUpperCase()).lastName(person.lastName().toUpperCase()).build();
        log.info("Converting {} into {}", person, transformedPerson);
        return transformedPerson;
    }
}
