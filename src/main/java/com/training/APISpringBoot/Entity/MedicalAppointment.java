package com.training.APISpringBoot.Entity;


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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private LocalDateTime fecha;

    private String appointmentType;

}
