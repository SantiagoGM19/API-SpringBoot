package com.training.APISpringBoot.Controller;

import com.training.APISpringBoot.Entity.Doctor;
import com.training.APISpringBoot.Entity.Person;
import com.training.APISpringBoot.Service.ServicesInterfaces.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Keymap;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/crudDoctors")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @GetMapping("get/doctors")
    public ResponseEntity getAllDoctors(){
        try {
            List<Doctor> doctors = doctorService.getAllDoctors();
            return ResponseEntity.ok().header("Doctors found").body(doctors);
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while requesting the doctors");
        }
    }

    @GetMapping("get/doctors/{id}")
    public ResponseEntity getOneDoctor(@PathVariable Long id){
        try{
            Doctor doctor = doctorService.getOneDoctor(id);
            return ResponseEntity.ok().header("Doctor found").body(doctor);
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while requesting the doctor");
        }
    }

    @PostMapping("create/doctors")
    public ResponseEntity createDoctor(@RequestBody Doctor doctor){
        try{
            Doctor doctorCreated = doctorService.saveDoctor(doctor);
            return ResponseEntity.ok().header("Doctor created successfully").body(doctorCreated);
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while creating the person");
        }
    }

    @PutMapping("update/doctors")
    public ResponseEntity updatePerson(@RequestBody Doctor doctor){
        try{
            doctorService.updateDoctor(doctor);
            return ResponseEntity.ok().body("Doctor updated correctly");
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while updating the doctor");
        }
    }

    @DeleteMapping("delete/doctors/{id}")
    public ResponseEntity deleteDoctor(@PathVariable Long id){
        try{
            doctorService.deleteDoctor(id);
            return ResponseEntity.ok().body("Doctor deleted correctly");
        }catch (Exception error){
            return ResponseEntity.badRequest().body("An error occurred while deleting the doctor");
        }
    }
}
