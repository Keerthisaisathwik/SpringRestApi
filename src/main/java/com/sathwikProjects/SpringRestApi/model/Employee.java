package com.sathwikProjects.SpringRestApi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

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
	//@Column(name="id")
	private Long id;
	
	//@JsonProperty("full_name")
	//@Column(name="name")
	@NotBlank(message = "name is mandatory(cannot be blank)")
	private String name;
	
	//@JsonIgnore
	//@Column(name="age")
	private Long age = 0L;
	
	//@Column(name="location")
	@NotBlank(message = "location is mandatory(cannot be blank)")
	private String location;
	
	//@Column(name="email")
	@Email(message="please enter valid email address")
	private String email;
	
	//@Column(name="department")
	@NotBlank(message = "department is mandatory(cannot be blank)")
	private String department;

	@CreationTimestamp
	@Column(name="created_at", nullable=false, updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
}
