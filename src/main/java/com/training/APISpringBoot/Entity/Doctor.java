package com.training.APISpringBoot.Entity;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "Doctor")
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "doctorId")
@Data
public class Doctor extends Person{

    private String specialization;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;
}
