package com.training.APISpringBoot.Service.ServicesImplementations;
import com.training.APISpringBoot.Entity.Doctor;
import com.training.APISpringBoot.Repository.DoctorRepository;
import com.training.APISpringBoot.Service.ServicesInterfaces.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> getOneDoctor(Long id) throws Exception {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if(!doctor.isEmpty()){
            return doctor;
        }
        throw new Exception("No doctor was found with this id");
    }

    @Override
    public void updateSpecialization(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
