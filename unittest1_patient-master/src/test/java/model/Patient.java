package model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class Patient {
}
package com.example.demo.controller;

import com.example.demo.model.PatientRecord;
import com.example.demo.repository.PatientRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PatientRecordController {

    PatientRecordRepository patientRecordRepository;

    @GetMapping("/patient")
    public List<PatientRecord> showAll(){return patientRecordRepository.findAll();}

    @PostMapping("/patients")
    public String addStudent(@RequestBody PatientRecord patient){
        boolean studentExist =patientRecordRepository.existsById(Math.toIntExact(patient.getId()));
        if(!studentExist){
            patientRecordRepository.save(patient);
            return "Record saved Successfully";
        }else {
            return "Student Exist";
        }
    }

    @DeleteMapping("/patient/{id}")
    public String deleteStudent(@PathVariable Long id) {
        boolean studentExist =patientRecordRepository.existsById(Math.toIntExact(id));
        if(studentExist) {
            patientRecordRepository.deleteById(Math.toIntExact(id));
            return "Deleted Successfully";
        }
        else {
            return "Record Doesn't exist";
        }
    }
}