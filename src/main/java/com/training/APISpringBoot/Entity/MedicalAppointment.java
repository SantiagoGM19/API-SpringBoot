package com.training.APISpringBoot.Entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private List<Doctor> doctors = new ArrayList<>();

    private List<Patient> patients = new ArrayList<>();

    public MedicalAppointment addDoctors(Doctor doctor){
        this.doctors.add(doctor);
        return this;
    }

    public MedicalAppointment addPatient(Patient patient){
        this.patients.add(patient);
        return this;
    }

}
