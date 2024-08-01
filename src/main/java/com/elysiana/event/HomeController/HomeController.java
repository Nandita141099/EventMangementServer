package com.elysiana.event.HomeController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	@PreAuthorize("hasRole(NORMAL)")
	@GetMapping("/normal)")
	public ResponseEntity<String>normalUser(){
		return ResponseEntity.ok("Yes, Iam normal User");
	}
	@PreAuthorize("hasRole(ADMIN)")
	@GetMapping("/admin)")
	public ResponseEntity<String>adminUser(){
		return ResponseEntity.ok("Yes, Iam admin User");
	}
	@GetMapping("/public)")
	public ResponseEntity<String>publicUser(){
		return ResponseEntity.ok("Yes, Iam public User");
	}
}
