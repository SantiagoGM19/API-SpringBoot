package com.training.APISpringBoot.Controller;

import com.training.APISpringBoot.Entity.MedicalAppointment;
import com.training.APISpringBoot.Entity.Patient;
import com.training.APISpringBoot.Service.ServicesInterfaces.IMedicalAppointmentService;
import com.training.APISpringBoot.Service.ServicesInterfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/crudAppointments")
public class MedicalAppointmentController {
    @Autowired
    private IMedicalAppointmentService medicalAppointmentService;

    @GetMapping("get/appointments")
    public ResponseEntity getAllMedicalAppointments(){
        try {
            List<MedicalAppointment> medicalAppointments = medicalAppointmentService.getAllMedicalAppointments();
            return ResponseEntity.ok().header("Medical appointments found").body(medicalAppointments);
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while requesting the medical appointments");
        }
    }

    @GetMapping("get/appointments/{id}")
    public ResponseEntity getOneMedicalAppointment(@PathVariable Long id){
        try{
            MedicalAppointment medicalAppointment = medicalAppointmentService.getOneMedicalAppointment(id);
            return ResponseEntity.ok().header("Medical appointment found").body(medicalAppointment);
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while requesting the medical appointment");
        }
    }

    @PostMapping("create/appointments")
    public ResponseEntity createMedicalAppointment(@RequestBody MedicalAppointment medicalAppointment){
        try{
            MedicalAppointment medicalAppointmentCreated = medicalAppointmentService.saveMedicalAppointment(medicalAppointment);
            System.out.println(medicalAppointmentCreated);
            return ResponseEntity.ok().header("Medical appointment created successfully").body(medicalAppointmentCreated);
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while creating the medical appointment:  "+error.getMessage());
        }
    }

    @PutMapping("update/appointments")
    public ResponseEntity updateMedicalAppointment(@RequestBody MedicalAppointment medicalAppointment){
        try{
            medicalAppointmentService.updateMedicalAppointment(medicalAppointment);
            return ResponseEntity.ok().body("Medical appointment updated correctly");
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while updating the medical appointment");
        }
    }

    @DeleteMapping("delete/appointments/{id}")
    public ResponseEntity deleteMedicalAppointment(@PathVariable Long id){
        try{
            medicalAppointmentService.deleteMedicalAppointment(id);
            return ResponseEntity.ok().body("Medical appointment deleted correctly");
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while deleting the medical appointment");
        }
    }
}
