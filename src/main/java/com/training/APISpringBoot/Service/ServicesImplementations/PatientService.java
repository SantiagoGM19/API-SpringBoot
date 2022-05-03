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
    PatientRepository patientRepository;

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getOnePatient(Long id) throws Exception {
        Optional<Patient> patient = patientRepository.findById(id);
        if(!patient.isEmpty()){
            return patient;
        }
        throw new Exception("No patient was found with this id");
    }

    @Override
    public void updateMedicalDescription(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
