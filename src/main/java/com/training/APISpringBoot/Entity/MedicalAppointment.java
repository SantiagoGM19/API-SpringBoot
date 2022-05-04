package com.training.APISpringBoot.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.print.Doc;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "MedicalAppointment")
@Table(name = "medicalAppointments")
@Data
public class MedicalAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long fkPatientId;

    private Long fkDoctorId;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = Patient.class
    )
    List<Patient> patients = new ArrayList<>();


    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = Doctor.class
    )
    List<Doctor> doctors = new ArrayList<>();

    private String date;

    private String appointmentType;

    public MedicalAppointment addPatient(Patient patient){
        this.patients.add(patient);
        return this;
    }

    public MedicalAppointment addDoctor(Doctor doctor){
        this.doctors.add(doctor);
        return this;
    }

}
