package com.training.APISpringBoot.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Patient")
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "patientId")
@Data
public class Patient extends Person{

    private String medicalDescription;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;
}
