package com.service;


	

	












import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exception.CustomException;
import com.model.Patient;
import com.repository.PatientRepository;




@Service
public class PatientService {
	@Autowired
	RestTemplate restTemplate;

	
	@Autowired
    private PatientRepository patientRepository;
	 public Patient registerPatient(Patient patient) {
		 
		 return patientRepository.save(patient);
	    }
	 public Patient authenticatedPatient(String email, String password_hash) {
	        Patient patient = patientRepository.findByEmail(email);
	        if (patient != null && patient.getPassword_hash().equals(password_hash)) {
	            return patient;
	        }
	        return null;
	
	
	 }
}

	    
	 
	
	    
	

    
    
    
        
    





