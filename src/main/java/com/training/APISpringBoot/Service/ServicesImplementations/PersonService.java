package com.training.APISpringBoot.Service.ServicesImplementations;

import com.training.APISpringBoot.Entity.Person;
import com.training.APISpringBoot.Repository.PersonRepository;
import com.training.APISpringBoot.Service.ServicesInterfaces.IPersonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(Person person){
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getOnePerson (Long id) throws Exception {
         Optional<Person> person = personRepository.findById(id);
         if(!person.isEmpty()){
             return person.get();
         }
         throw new Exception("No person was found with this id");
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
