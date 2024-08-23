package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Doctor;
import com.repository.DoctorRepository;

@Service
	public class DoctorService {
	@Autowired
    DoctorRepository doctorRepository;
	 public Optional<Doctor> getDoctorById(int doctor_id) {
	        return doctorRepository.findById(doctor_id);
	    }
	 public List<Doctor> getDoctorsBySpecialization(String specialization) {
	        return doctorRepository.findBySpecialization(specialization);
	    }
	}
    


	  