package com.training.APISpringBoot.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Patient")
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "patientId")
@Data
public class Patient extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String medicalDescription;

    private Long fkMedicalAppointmentId;

}
