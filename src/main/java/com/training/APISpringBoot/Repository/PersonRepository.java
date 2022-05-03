package com.training.APISpringBoot.Repository;

import com.training.APISpringBoot.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
