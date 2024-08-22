package com.service;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.model.Patient;
import com.repository.PatientRepository;

	@Service
	public class PatientService {

	    @Autowired
	    private PatientRepository patientRepository;

	    @Autowired
	    private RestTemplate restTemplate; // For communication with Doctor Service

	    public Patient register(Patient patient) {
	        // Basic validation and password hashing
	        return patientRepository.save(patient);
	    }

	    public Patient login(String username, String password) {
	        // Authentication logic
	        return patientRepository.findByUsername(username);
	    }

	   /* public List<Doctor> getDoctorsBySpecialization(String specialization) {
	        String url = "http://localhost:8081/doctors/specialization/" + specialization;
	        ResponseEntity<Doctor[]> response = restTemplate.getForEntity(url, Doctor[].class);
	        return Arrays.asList(response.getBody());
	    }

	    public Appointment bookAppointment(Appointment appointment) {
	        // Validate doctor and patient, then save appointment
	        return appointmentRepository.save(appointment);
	    }

	    public List<Appointment> getAppointmentsForCurrentMonth(Patient patient) {
	        LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
	        LocalDate endOfMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());
	        return appointmentRepository.findByPatientAndAppointmentDateBetween(patient, startOfMonth, endOfMonth);
	    }
}*/


}
