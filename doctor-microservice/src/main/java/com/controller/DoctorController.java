package com.controller;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Doctor;
import com.service.DoctorService;


	@RestController
	@RequestMapping("/doctors")
	public class DoctorController {

	   
	    @Autowired
	     DoctorService doctorService;

		@GetMapping("/{doctor_id}")
	    public ResponseEntity<Doctor> getDoctorById(@PathVariable int doctor_id) {
	        Optional<Doctor> doctor = doctorService.getDoctorById(doctor_id);
	        return doctor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	        

	      
		}
		@GetMapping("/specialization/{specialization}")
	    public ResponseEntity<List<Doctor>> getDoctorsBySpecialty(@PathVariable String specialization) {
	        List<Doctor> doctors = doctorService.getDoctorsBySpecialization(specialization);
	        if (doctors.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(doctors);
	    }
	}
	
	    

