package com.controller;


	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.model.Patient;
import com.service.PatientService;

import jakarta.validation.Valid;

import java.util.List;
@Validated
	@RestController
	@RequestMapping("/patients")
	public class PatientController {

	    @Autowired
	    private PatientService patientService;

	    @PostMapping("/register")
	    public ResponseEntity<Patient> register(@Valid @RequestBody Patient patient) {
	        return ResponseEntity.ok(patientService.register(patient));
	    }

	    @PostMapping("/login")
	    public ResponseEntity<Patient> login(@RequestParam String username, @RequestParam String password) {
	        Patient patient = patientService.login(username, password);
	        if (patient != null) {
	            return ResponseEntity.ok(patient);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	        }
	    }

	   // @GetMapping("/doctors")
	   // public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@RequestParam String specialization) {
	       // return ResponseEntity.ok(patientService.getDoctorsBySpecialization(specialization));
	   // }

	    //@PostMapping("/appointments")
	   // public ResponseEntity<Appointment> bookAppointment(@Valid @RequestBody Appointment appointment) {
	    //    return ResponseEntity.ok(patientService.bookAppointment(appointment));
	    //}

	    //@GetMapping("/appointments")
	   // public ResponseEntity<List<Appointment>> getAppointmentsForCurrentMonth(@RequestParam Long patientId) {
	     //   Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
	        //return ResponseEntity.ok(patientService.getAppointmentsForCurrentMonth(patient));
	   // }
	//}

}
