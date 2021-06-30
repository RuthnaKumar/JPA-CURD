package com.rk.restapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")  //@Column is not mandatory if column and field name will be same
	private long id;
	//@JsonProperty("full_name") (alternate name for the data or variable)
	@Column(name = "name")
	@NotEmpty(message = "Name should not be null")   //@NotEmpty used to validation 
	private String name;
	//@JsonIgnore   (for ignore or hide the details) 
	@Column(name = "age")
	private Long age = 0L;
	@NotBlank(message = "Value not be blank space")    //@NotBlank for validate blank space
	@Column(name = "location")
	private String location;
	@Column(name = "email")
	@Email(message = " Enter Valid email ")
	private String email;
	@Column(name = "department")
	@NotEmpty(message = "Department should not be null") 
	private String department;
	
	
	//TIMESTAMP
	@CreationTimestamp()
	@Column(name = "created_at",nullable =false, updatable = false)
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updateAt;
}
