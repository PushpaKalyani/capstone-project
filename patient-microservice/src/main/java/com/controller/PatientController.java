package com.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.exception.CustomException;
import com.model.Doctor;
import com.model.Patient;
import com.service.PatientService;

import jakarta.validation.Valid;




@RestController
	@RequestMapping("/patients")
	public class PatientController {
	@Autowired
	RestTemplate restTemplate;

String baseUrl = "http://doctor-service/";

	 @Autowired
	    private PatientService patientService;
	 
	 @PostMapping
	    public ResponseEntity<Patient> registerPatient( @RequestBody Patient patient)   {
		 
		 Patient registeredPatient = patientService.registerPatient(patient);
		 return ResponseEntity.ok(registeredPatient);
		  
		 
		       
		     }    
	    
	 @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody Patient patient) {
	        Patient authenticatedPatient = patientService.authenticatedPatient(patient.getEmail(), patient.getPassword_hash());
	        if (authenticatedPatient != null) {
	            String message = "You have successfully logged in";

	            return ResponseEntity.ok(message);
	        } else {
	            return ResponseEntity.status(401).body("Invalid email or password");
	        }
	    }
	 @GetMapping("/doctors/{doctor_id}")
		public ResponseEntity<?> getDoctorById(@Valid @PathVariable("doctor_id") int Id) {
			String url = "http://doctor-service/doctors/" + Id;
			System.out.println(url);
			// assuming the doctor microservice has a /doctors
																	// endpoint

			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

			if (response.getStatusCode().isSameCodeAs(HttpStatus.OK)) {
				return ResponseEntity.ok(response.getBody());
			} else if (response.getStatusCode().isSameCodeAs(HttpStatus.NO_CONTENT)) {
				return new ResponseEntity<>("No Doctor found with that id ", HttpStatus.NOT_FOUND);
			}
			//return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
			return new ResponseEntity<>(response.getBody(),response.getStatusCode());
			
		}
	 private String buildUrl(String baseUrl, String param, String value) {
			String url = UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam(param, value).toUriString();
			return url;
		}
	 @GetMapping("/doctors")
	    public ResponseEntity<?> showDoctorsBySpecialization(@RequestParam("specialization") String specialization) {
	        //logger.info("Fetching doctors with specialization: {}", specialization);
	        String url = buildUrl(baseUrl, "specialization", specialization);
	       // logger.debug("Constructed URL: {}", url);
	        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, null,
	                new ParameterizedTypeReference<List>() {
	                });
	        if (response.getStatusCode().is2xxSuccessful()) {
	            //logger.info("Doctors found: {}", response.getBody());
	            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
	        } else if (response.getStatusCode().is4xxClientError()) {
	           // logger.warn("No doctor record found for specialization: {}", specialization);
	            return new ResponseEntity<>("No doctor record found for specialization", HttpStatus.NOT_FOUND);
	        }
	       // logger.error("Error occurred while fetching doctors by specialization: {}", specialization);
	        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
	    }

	 
			
	   
	    }
	


	
	
	
	
	   


	  