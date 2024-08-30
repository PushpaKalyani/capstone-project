package com.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="doctors2")
	public class Doctor {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int doctor_id;
	    @NotEmpty(message="full_name not provided")
		@Column(name="full_name")
	    private String full_name;
	    @NotEmpty(message="specialization not provided")
		@Column(name="specialization")
	    private String specialization;
        
	    private String available_days;
        
		public int getDoctor_id() {
			return doctor_id;
		}
		public void setDoctor_id(int doctor_id) {
			this.doctor_id = doctor_id;
		}
		public String getAvailable_days() {
			return available_days;
		}
		public void setAvailable_days(String available_days) {
			this.available_days = available_days;
		}
		public String getFull_name() {
			return full_name;
		}
		public void setFull_name(String full_name) {
			this.full_name = full_name;
		}
		public String getSpecialization() {
			return specialization;
		}
		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}
		
		
		public Doctor() {
			super();
			}
		public Doctor(int doctor_id, String full_name, String specialization, String available_days) {
			super();
			this.doctor_id = doctor_id;
			this.full_name = full_name;
			this.specialization = specialization;
			this.available_days = available_days;
		}
	    

}
