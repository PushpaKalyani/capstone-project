package com.repository;


	

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.model.Appointment;



	//import java.util.List;

	public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
		
	}

	