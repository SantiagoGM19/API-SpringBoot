package com.training.APISpringBoot.Service.ServicesImplementations;

import com.training.APISpringBoot.Entity.Patient;
import com.training.APISpringBoot.Repository.PatientRepository;
import com.training.APISpringBoot.Service.ServicesInterfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getOnePatient(Long id) throws Exception {
        Optional<Patient> patient = patientRepository.findById(id);
        if(!patient.isEmpty()){
            return patient.get();
        }
        throw new Exception("No patient was found with this id");
    }

    @Override
    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
