package com.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.CustomException;
import com.model.Doctor;
import com.service.DoctorService;

import jakarta.validation.Valid;

@Validated
	@RestController
	@RequestMapping("/doctors")
	public class DoctorController {
	 

	 
	
	   
	    @Autowired
	     DoctorService doctorService;
		@GetMapping("/{doctor_id}")
		
	    public ResponseEntity<Doctor> getDoctorById(@Valid @PathVariable int doctor_id) throws CustomException {
	        Optional<Doctor> doctor = doctorService.getDoctorById(doctor_id);
	        Logger logger = LoggerFactory.getLogger(DoctorController.class); 
	        logger.info("method invocation started");

	        if (!doctor.isPresent()) {
	            throw new CustomException("Doctor with ID " + doctor_id + " not found.");
	            
	        }
	        return ResponseEntity.ok(doctor.get());
	        
	        //return doctor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
		}

	      
		
		@GetMapping("/specialization/{specialization}")
	    public ResponseEntity<List<Doctor>> getDoctorsBySpecialty(@PathVariable String specialization) throws CustomException {
	        List<Doctor> doctors = doctorService.getDoctorsBySpecialization(specialization);
	        //if (doctors.isEmpty()) {
	          //  return ResponseEntity.noContent().build();
	       // }
	        //return ResponseEntity.ok(doctors);
	        if (specialization == null || specialization.trim().isEmpty()) {
	            throw new CustomException("Specialization must not be empty.");
	        }
	       
	        
	        if (doctors.isEmpty()) {
	            throw new CustomException("No doctors found with specialization: " + specialization);
	        }
	        return ResponseEntity.ok(doctors);
	        	    }
	}
	
	    

