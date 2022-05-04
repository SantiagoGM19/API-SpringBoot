package com.training.APISpringBoot.Service.ServicesInterfaces;

import com.training.APISpringBoot.Entity.Patient;

import java.util.List;

public interface IPatientService {

    Patient savePatient(Patient patient);

    //this method should return the data related with person too
    List<Patient> getAllPatients();

    Patient getOnePatient(Long id) throws Exception;

    //It is only allowed to modify the medical description
    void updatePatient(Patient patient);


    void deletePatient(Long id);
}
