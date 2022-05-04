package com.training.APISpringBoot.Controller;


import com.training.APISpringBoot.Entity.Person;
import com.training.APISpringBoot.Service.ServicesInterfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/crudPersons")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping("get/persons")
    public List<Person> getAllPersons(){
         return personService.getAllPersons();
    }

    @GetMapping("get/persons/{id}")
    public ResponseEntity getOnePerson(@PathVariable Long id){
        try{
            Person person = personService.getOnePerson(id);
            return new ResponseEntity("Person found!", (MultiValueMap<String, String>) person, HttpStatus.FOUND);
        }catch (Exception error){
            return new ResponseEntity(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("create/persons")
    public ResponseEntity createPerson(@RequestBody Person person){
        try{
            Person personCreated = personService.savePerson(person);
            return ResponseEntity.ok().header("Person created successfully").body(personCreated);
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while creating the person");
        }
    }

    @PutMapping("update/persons")
    public ResponseEntity updatePerson(@RequestBody Person person){
        try{
            personService.updatePerson(person);
            return ResponseEntity.ok().body("Person updated correctly");
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while creating the person");
        }
    }

    @DeleteMapping("delete/persons/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id){
        try{
            personService.deletePerson(id);
            return ResponseEntity.ok().body("Person deleted correctly");
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while creating the person");
        }
    }
}
