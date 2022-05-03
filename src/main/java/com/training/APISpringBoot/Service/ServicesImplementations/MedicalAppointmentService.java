package com.training.APISpringBoot.Service.ServicesImplementations;

import com.training.APISpringBoot.Entity.Doctor;
import com.training.APISpringBoot.Entity.MedicalAppointment;
import com.training.APISpringBoot.Entity.Patient;
import com.training.APISpringBoot.Repository.MedicalAppointmentRepository;
import com.training.APISpringBoot.Service.ServicesInterfaces.IMedicalAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalAppointmentService implements IMedicalAppointmentService {

    @Autowired
    MedicalAppointmentRepository medicalAppointmentRepository;

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @Override
    public String saveMedicalAppointment(MedicalAppointment medicalAppointment){
        try{
            Optional<Doctor> doctor = doctorService.getOneDoctor(medicalAppointment.getDoctor().getId());
            Optional<Patient> patient = patientService.getOnePatient(medicalAppointment.getDoctor().getId());

            medicalAppointment.addDoctors(doctor.get());
            medicalAppointment.addPatient(patient.get());

            medicalAppointmentRepository.save(medicalAppointment);

        }catch (Exception error){
            return error.getMessage();
        }
        return "medical appointment saved correctly";
    }

    @Override
    public List<MedicalAppointment> getAllMedicalAppointments() {
        return medicalAppointmentRepository.findAll();
    }

    @Override
    public MedicalAppointment getOneMedicalAppointment(Long id) throws Exception {
        Optional<MedicalAppointment> medicalAppointment = medicalAppointmentRepository.findById(id);
        if(!medicalAppointment.isEmpty()){
            return medicalAppointment.get();
        }
        throw new Exception("No medical appointment was found with this id");
    }

    @Override
    public void updateMedicalAppointment(MedicalAppointment medicalAppointment) {
        medicalAppointmentRepository.save(medicalAppointment);
    }

    @Override
    public void deleteMedicalAppointment(Long id) {
        medicalAppointmentRepository.deleteById(id);
    }
}
