package com.training.APISpringBoot.Entity;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "Doctor")
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "doctorId")
@Data
public class Doctor extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String specialization;

    private Long fkMedicalAppointmentId;

}
