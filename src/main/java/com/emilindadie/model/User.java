package com.emilindadie.model;

import java.util.UUID;

public class User {
	private UUID uid;
    private String name;
    private String email;
    private String password;
    private String address;
    
    
    public User(String name, String email, String address, String password) {
    	this.name = name;
    	this.email = email;
    	this.address = address;
    	this.password = password;	
    } 

	public UUID getUid() {
		return uid;
	}
	public void setUid(UUID uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
