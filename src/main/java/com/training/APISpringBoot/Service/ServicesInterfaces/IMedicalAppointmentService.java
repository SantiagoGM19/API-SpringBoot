package com.training.APISpringBoot.Service.ServicesInterfaces;

import com.training.APISpringBoot.Entity.MedicalAppointment;

import java.util.List;

public interface IMedicalAppointmentService {

    String saveMedicalAppointment(MedicalAppointment medicalAppointment) throws Exception;

    //this method should return the data related with person too
    List<MedicalAppointment> getAllMedicalAppointments();

    MedicalAppointment getOneMedicalAppointment(Long id) throws Exception;

    //It is only allowed to modify the medical description
    void updateMedicalAppointment(MedicalAppointment medicalAppointment);

    void deleteMedicalAppointment(Long id);
}
