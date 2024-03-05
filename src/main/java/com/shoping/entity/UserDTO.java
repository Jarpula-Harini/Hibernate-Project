package com.shoping.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	@Column(name = "userName")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "address")
	private String address;
	@Column(name = "phoneNumber")
	private int phoneNumber;
	
	@OneToMany
	private List<OrderDTO> orders = new ArrayList<>();
	
	
	// Default Constructor
	public UserDTO() {}
	
	

	
	
}
