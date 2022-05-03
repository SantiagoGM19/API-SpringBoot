package com.training.APISpringBoot.Service.ServicesInterfaces;

import com.training.APISpringBoot.Entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface IDoctorService {

    void saveDoctor(Doctor doctor);

    //this method should return the data related with person too
    List<Doctor> getAllDoctors();

    Optional<Doctor> getOneDoctor(Long id) throws Exception;

    //It is only allowed to modify the specialization of the doctor
    void updateSpecialization(Doctor doctor);


    void deleteDoctor(Long id);
}
