package com.training.APISpringBoot.Controller;

import com.training.APISpringBoot.Entity.Patient;
import com.training.APISpringBoot.Service.ServicesInterfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/crudPatients")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @GetMapping("get/patients")
    public ResponseEntity getAllPatients(){
        try {
            List<Patient> patients = patientService.getAllPatients();
            return ResponseEntity.ok().header("Patients found").body(patients);
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while requesting the patients");
        }
    }

    @GetMapping("get/patients/{id}")
    public ResponseEntity getOnePatient(@PathVariable Long id){
        try{
            Patient patient = patientService.getOnePatient(id);
            return ResponseEntity.ok().header("Doctor found").body(patient);
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while requesting the patient");
        }
    }

    @PostMapping("create/patients")
    public ResponseEntity createPatient(@RequestBody Patient patient){
        try{
            Patient patientCreated = patientService.savePatient(patient);
            return ResponseEntity.ok().header("Patient created successfully").body(patientCreated);
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while creating the patient");
        }
    }

    @PutMapping("update/patients")
    public ResponseEntity updatePatient(@RequestBody Patient patient){
        try{
            patientService.updatePatient(patient);
            return ResponseEntity.ok().body("Patient updated correctly");
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while updating the patient");
        }
    }

    @DeleteMapping("delete/patients/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id){
        try{
            patientService.deletePatient(id);
            return ResponseEntity.ok().body("Patient deleted correctly");
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while deleting the patient");
        }
    }
}
