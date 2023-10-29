package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	public Users findUserByEmail(String eamil);
}
