package com.training.APISpringBoot.Service.ServicesImplementations;

import com.training.APISpringBoot.Entity.Doctor;
import com.training.APISpringBoot.Entity.MedicalAppointment;
import com.training.APISpringBoot.Entity.Patient;
import com.training.APISpringBoot.Repository.DoctorRepository;
import com.training.APISpringBoot.Repository.MedicalAppointmentRepository;
import com.training.APISpringBoot.Repository.PatientRepository;
import com.training.APISpringBoot.Service.ServicesInterfaces.IMedicalAppointmentService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.spi.DateFormatProvider;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalAppointmentService implements IMedicalAppointmentService {

    @Autowired
    private MedicalAppointmentRepository medicalAppointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public MedicalAppointment saveMedicalAppointment(MedicalAppointment medicalAppointment) {
        return medicalAppointmentRepository.save(medicalAppointment);
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
        Patient patient = patientRepository.getById(medicalAppointment.getFkPatientId());
        Doctor doctor = doctorRepository.getById(medicalAppointment.getFkDoctorId());
        medicalAppointment.addDoctor(doctor);
        medicalAppointment.addPatient(patient);
        medicalAppointmentRepository.save(medicalAppointment);
    }

    @Override
    public void deleteMedicalAppointment(Long id) {
        medicalAppointmentRepository.deleteById(id);
    }
}
