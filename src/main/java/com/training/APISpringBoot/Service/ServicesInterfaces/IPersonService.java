package com.training.APISpringBoot.Service.ServicesInterfaces;

import com.training.APISpringBoot.Entity.Person;

import java.util.List;

public interface IPersonService {

    Person savePerson(Person person);

    List<Person> getAllPersons();

    Person getOnePerson(Long id) throws Exception;

    void updatePerson(Person person);

    void deletePerson(Long id);
}
