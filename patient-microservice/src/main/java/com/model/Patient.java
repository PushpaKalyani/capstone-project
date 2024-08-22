package com.model;

import java.util.Date;

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

	    @Column(nullable = false, unique = true)
	    private String patient_name ;

	    @Column(nullable = false)
	    private String password_hash;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column()
	    private String gender;
	    @Column()
	    private Integer date_of_birth;
	    @Column()
	    private int phone_number;
	    // Getters and Setters
	}



