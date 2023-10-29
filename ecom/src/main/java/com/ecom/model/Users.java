package com.ecom.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Users {
 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
 private long usersId;
 private String name;
 private String mobile;
 private String mobile2;
 private String dob;
 private String role;
 private String email;
 private String password;
 private String username;
 
 @OneToMany
 private List<UserAddress> address;

public long getUsersId() {
	return usersId;
}

public void setUsersId(long usersId) {
	this.usersId = usersId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getMobile2() {
	return mobile2;
}

public void setMobile2(String mobile2) {
	this.mobile2 = mobile2;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
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

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}


 
 
}

