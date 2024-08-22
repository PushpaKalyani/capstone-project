package com.repository;


	import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Patient;

	public interface PatientRepository extends JpaRepository<Patient, Long> {
	    Patient findByUsername(String username);
	    Patient findByEmail(String email);
	}

	//public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	    //List<Appointment> findByPatientAndAppointmentDateBetween(Patient patient, LocalDate startDate, LocalDate endDate);
	//}


//}
