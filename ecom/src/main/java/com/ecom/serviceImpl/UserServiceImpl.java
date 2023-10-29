package com.ecom.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.model.Users;
import com.ecom.repository.UserRepository;
import com.ecom.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	 @Autowired
	    private UserRepository userRepository; // Assume you have a UserRepository interface

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    public Users registerUser(Users user) {
	        // Check if the user with this email already exists
	        if (userRepository.findUserByEmail(user.getEmail()) != null) {
	            throw new RuntimeException("Email already exists");
	        }

	        // Encode the password before saving it to the database
	        user.setPassword(passwordEncoder.encode(user.getPassword()));

	        // Save the user details to the database
	        return userRepository.save(user);
	    }
}
