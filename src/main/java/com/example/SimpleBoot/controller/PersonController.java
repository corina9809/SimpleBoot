package com.example.SimpleBoot.controller;


import com.example.SimpleBoot.entity.Person;
import com.example.SimpleBoot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonPagingRepository personPagingRepository;


    @RequestMapping(
            method = RequestMethod.GET,
            path = "/personPaging/{page}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> getPagingPreson(@PathVariable("page") Integer page){

        List<Person> listperson = personPagingRepository.findAll(
                PageRequest.of(page,1)
        ).getContent();

        return listperson;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/person",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @Cacheable("person")
    public List<Person> getPreson(){

        List<Person> listperson = personRepository.findAll();
        return listperson;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/person",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person savePerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/person",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Transactional
    public Integer updatePerson(@RequestBody Person person){
        return personRepository.updatePerson(
                person.getId(),
                person.getVorname(),
                person.getNachname(),
                person.getGeburtddatum()
        );
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/person2",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Transactional
    public Person updatePerson2(@RequestBody Person person){

        Person updatePerson = personRepository.getOne(person.getId());

        updatePerson.setNachname(person.getNachname());
        updatePerson.setVorname(person.getVorname());
        updatePerson.setGeburtddatum(person.getGeburtddatum());
        return personRepository.saveAndFlush(updatePerson);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/person/{id}"
    )
    public void deletePreson(@PathVariable("id") Integer id){
        personRepository.deleteById(id);
    }

}
