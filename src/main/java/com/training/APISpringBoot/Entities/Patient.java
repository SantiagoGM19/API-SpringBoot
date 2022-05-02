package com.training.APISpringBoot.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Patient")
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "patientId")
@Data
public class Patient extends Person{

    private String medicalDescription;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Long fkPersonId;
}
