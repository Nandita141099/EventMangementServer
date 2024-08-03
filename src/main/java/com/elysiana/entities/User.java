package com.elysiana.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  userId;
	private String name;
	private String email;
	private String password;
    private String contact;
    private String role;
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Event> event;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> booking;
    
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Review> review;
}
