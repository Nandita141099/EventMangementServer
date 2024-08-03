package com.elysiana.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elysiana.config.JwtUtil;
import com.elysiana.payloads.AuthenticationRequest;
import com.elysiana.payloads.AuthenticationResponse;
import com.elysiana.payloads.SignupRequest;
import com.elysiana.service.UserService;
import com.elysiana.service.impl.UserDetailsImpl;
import com.elysiana.service.impl.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserService userService;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
			@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		// Authenticate the user
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getEmail(), authenticationRequest.getPassword()));

		// Load user details
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

		// Generate JWT token
		final String jwtToken = jwtUtil.generateToken(userDetails);

		// Cast UserDetails to UserDetailsImpl to access custom fields
		if (!(userDetails instanceof UserDetailsImpl)) {
			throw new IllegalArgumentException("UserDetails is not an instance of UserDetailsImpl");
		}

		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) userDetails;

		// Create and return the response with JWT and user details
		AuthenticationResponse response = new AuthenticationResponse(jwtToken, userDetailsImpl.getUserId(),
				userDetailsImpl.getName(), userDetailsImpl.getUsername(), // Typically username is used as email
				userDetailsImpl.getContact(), userDetailsImpl.getAuthorities().iterator().next().getAuthority());

		return ResponseEntity.ok(response);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
		try {
			userService.signup(signupRequest);
			return ResponseEntity.ok("User registered successfully");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
