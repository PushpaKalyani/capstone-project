package com.model;





import java.sql.Date;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "patients1")

	public class Patient {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    
	    private int patient_id;

	    @Column(name="patient_name")
	    private String patient_name;
	    @Column(name="password_hash")
	    private String password_hash;
	    private String email;
        private String gender;
	    @Column(name="date_of_birth")
	    private Date date_of_birth;
	    
	    private String phone_number;
	    
	    

	    
		public String getPatient_name() {
			return patient_name;
		}
		public void setPatient_name(String patient_name) {
			this.patient_name = patient_name;
		}
		public String getPassword_hash() {
			return password_hash;
		}
		public void setPassword_hash(String password_hash) {
			this.password_hash = password_hash;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public Date getDate_of_birth() {
			return date_of_birth;
		}
		public void setDate_of_birth(Date date_of_birth) {
			this.date_of_birth = date_of_birth;
		}
		public String getPhone_number() {
			return phone_number;
		}
		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}
		public Patient() {
			super();}
		
	    // Getters and Setters

		public Patient( String patient_name, String password_hash, String email, String gender,
				Date date_of_birth, String phone_number) {
			super();
		
			this.patient_name = patient_name;
			this.password_hash = password_hash;
			this.email = email;
			this.gender = gender;
			this.date_of_birth = date_of_birth;
			this.phone_number = phone_number;
		}
		
		 
		
}



