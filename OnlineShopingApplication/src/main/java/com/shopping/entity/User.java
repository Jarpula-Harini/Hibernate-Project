package com.shopping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class User {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)

	private String userId;

	//@Pattern(regexp = "^[a-zA-Z]$", message = "username must be of 3 to 10 length with no special characters")
	private String userName;

	//@Pattern(regexp = "^[a-zA-Z0-9]{3,3}$", message = "password  must be of 3 to 5 length with  special characters")
	private String passWord;

	private String address;

	//@Pattern(regexp = "^[0-9]{10}$", message = "Phone Number must be of  10 digit of length ")
	private int phoneNumber;

	@ColumnDefault("'A'")
	private char status;

	// Default Constructor
	public User() {
	}

	public User(String userId, String userName, String passWord,String address, int phoneNumber,char status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", status=" + status + "]";
	}
	

}
