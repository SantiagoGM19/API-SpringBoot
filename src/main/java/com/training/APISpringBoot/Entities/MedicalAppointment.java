package com.training.APISpringBoot.Entities;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "MedicalAppointment")
@Table(name = "medicalAppointments")
@Data
public class MedicalAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Long fkPatientId;


    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Long fkDoctorId;

    private LocalDateTime fecha;

    private String appointmentType;

}
