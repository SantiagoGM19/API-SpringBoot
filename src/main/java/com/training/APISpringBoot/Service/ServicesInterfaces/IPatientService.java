package com.training.APISpringBoot.Service.ServicesInterfaces;

import com.training.APISpringBoot.Entity.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService {

    void savePatient(Patient patient);

    //this method should return the data related with person too
    List<Patient> getAllPatients();

    Optional<Patient> getOnePatient(Long id) throws Exception;

    //It is only allowed to modify the medical description
    void updateMedicalDescription(Patient patient);


    void deletePatient(Long id);
}
