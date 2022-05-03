package com.training.APISpringBoot.Service.ServicesInterfaces;

import com.training.APISpringBoot.Entity.Person;
import org.apache.coyote.Response;

import java.util.List;
import java.util.Optional;

public interface IPersonService {

    void savePerson(Person person);

    List<Person> getAllPersons();

    Optional<Person> getOnePerson(Long id) throws Exception;

    void updatePerson(Person person);

    void deletePerson(Long id);
}
