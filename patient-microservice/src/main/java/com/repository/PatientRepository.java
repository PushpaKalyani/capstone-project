package com.repository;


	





import org.springframework.data.jpa.repository.JpaRepository;


import com.model.Patient;

	
	

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Patient findByEmail(String email);

	 

	
	
        
    }



