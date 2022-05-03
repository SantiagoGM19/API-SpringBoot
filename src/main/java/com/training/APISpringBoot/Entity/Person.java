package com.training.APISpringBoot.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Person")
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private String phone;

}
