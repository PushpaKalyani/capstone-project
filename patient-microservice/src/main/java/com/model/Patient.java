package com.model;





import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
	public class Patient {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int patient_id;

	    @Column(name="patientname")
	    private String patient_name ;

	    public int getPatient_id() {
			return patient_id;
		}
		public void setPatient_id(int patient_id) {
			this.patient_id = patient_id;
		}
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
		@Column(name="passwordhash")
	    private String password_hash;

	    @Column(name="email")
	    private String email;

	    @Column(name="gender")
	    private String gender;
	    
	    private Date date_of_birth;
	    @Column()
	    private String phone_number;
	    // Getters and Setters

		public Patient(int patient_id, String patient_name, String password_hash, String email, String gender,
				Date date_of_birth, String phone_number) {
			super();
			this.patient_id = patient_id;
			this.patient_name = patient_name;
			this.password_hash = password_hash;
			this.email = email;
			this.gender = gender;
			this.date_of_birth = date_of_birth;
			this.phone_number = phone_number;
		}
		public Patient() {
			super();
	}
}



