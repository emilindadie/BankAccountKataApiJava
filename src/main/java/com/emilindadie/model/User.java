package com.emilindadie.model;

import java.io.Serializable;
import java.util.UUID;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;

import com.emilindadie.dto.SignUpDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    private int id;
	
	@Column()
    private String name = "";
	@Column()
    private String email = "";
	@Column()
    private String password = "";
	@Column()
    private String address = "";
    
    
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
	
	public Boolean validProperty() {
		return !this.name.isEmpty() && !this.email.isEmpty() &&  !this.address.isEmpty() && !this.password.isEmpty();
	}
	
	
	public void fromDto(SignUpDto data) {
		this.name = data.getName();
		this.email = data.getEmail();
		this.address = data.getAddress();
		this.password = data.getPassword();
	}
	
}
