package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.configuration.AuthRequest;
import com.ecom.configuration.JwtUtil;
import com.ecom.model.Users;
import com.ecom.service.UserService;

@RestController
@RequestMapping("v1/auth")
public class AuthenticationController {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
    private UserService userService;

	@GetMapping("/welcome")
	public String welcomeUrl() {
		return "Hello Dear How Are you ?";
	}

	
	@PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("Invalid credentials");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal server error");
        }

        String token = jwtUtil.generateToken(authRequest.getEmail());
        return ResponseEntity.status(200).body(token);
    }
	
	 @PostMapping("/signup")
	    public ResponseEntity<?> registerUser(@RequestBody Users user) {
	        try {
	            // Register the user
	            Users registeredUser = userService.registerUser(user);
	            return ResponseEntity.status(201).body("User registered successfully");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body("Internal server error");
	        }
	    }
}
