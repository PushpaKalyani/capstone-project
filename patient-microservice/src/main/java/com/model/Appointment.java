package com.model;


	import jakarta.persistence.*;

import java.time.LocalDate;


	@Entity
	@Table(name = "appointments2")
	public class Appointment {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int appointment_id;
	    
		
	    private int patient_id;
       	    private int doctor_id;
        
	    private LocalDate appointment_date;
		
	   		

		public int getPatient_id() {
			return patient_id;
		}

		public void setPatient_id(int patient_id) {
			this.patient_id = patient_id;
		}

		public int getDoctor_id() {
			return doctor_id;
		}

		public void setDoctor_id(int doctor_id) {
			this.doctor_id = doctor_id;
		}

		public LocalDate getAppointment_date() {
			return appointment_date;
		}

		public void setAppointment_date(LocalDate appointment_date) {
			this.appointment_date = appointment_date;
		}
		public Appointment() {
			super();}

		public Appointment(int patient_id, int doctor_id, LocalDate appointment_date) {
			super();
			this.patient_id = patient_id;
			this.doctor_id = doctor_id;
			this.appointment_date = appointment_date;
		}

		
	}
		

		
		

	    
	

