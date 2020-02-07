package com.emilindadie.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    private int id;
	
	@Column()
    private String name;
	@Column()
    private String email;
	@Column()
    private String password;
	@Column()
    private String address;
	
	@OneToMany(mappedBy="user")
    private List<Account> accounts = new ArrayList<>();
}
