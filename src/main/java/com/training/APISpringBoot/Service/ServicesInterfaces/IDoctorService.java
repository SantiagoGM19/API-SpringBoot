package com.training.APISpringBoot.Service.ServicesInterfaces;

import com.training.APISpringBoot.Entity.Doctor;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

public interface IDoctorService {

    Doctor saveDoctor(Doctor doctor);

    //this method should return the data related with person too
    List<Doctor> getAllDoctors();

    Doctor getOneDoctor(Long id) throws Exception;

    //It is only allowed to modify the specialization of the doctor
    void updateDoctor(Doctor doctor);


    void deleteDoctor(Long id);
}
