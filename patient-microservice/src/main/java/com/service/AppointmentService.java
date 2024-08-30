package com.service;







import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.model.Appointment;
import com.repository.AppointmentRepository;

@Service
	public class AppointmentService {
	
	@Autowired
    private AppointmentRepository appointmentRepository;

	
	public Appointment createAppointment(Appointment appointment)  {
		
		 return appointmentRepository.save(appointment);
		
    }
	public Optional<Appointment> getAppointmentsByPatientId(int patient_id) {
        return appointmentRepository.findById(patient_id);
    }
}
	    
    

    




