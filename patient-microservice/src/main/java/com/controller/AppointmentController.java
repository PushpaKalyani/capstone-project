package com.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.CustomException;
import com.model.Appointment;

import com.service.AppointmentService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/patients")
public class AppointmentController {
	@Autowired
	 private AppointmentService appointmentService;
	 
	@PostMapping("/appointments")
    public ResponseEntity<Appointment> createAppointment(@Valid @RequestBody Appointment appointment) {
		
       Appointment createdAppointment = appointmentService.createAppointment(appointment);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    
}
	
	@GetMapping("/appointments/{patient_id}")
    public ResponseEntity<Optional<Appointment>> getAppointmentsByPatientId(@PathVariable("patient_id") int patient_id) throws CustomException {
        //List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(patient_id);
       // if (appointments.isEmpty()) {
        //    return ResponseEntity.noContent().build();
        //}
      //  return ResponseEntity.ok(appointments);
		
	        Optional<Appointment> appointments = appointmentService.getAppointmentsByPatientId(patient_id);
	        if (appointments.isEmpty()) {
	        	throw new CustomException("No appointments found for patient ID: " + patient_id);
	           // return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(appointments);
	    } 
	}

	



