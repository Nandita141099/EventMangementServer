package com.elysiana.event.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		/*
		 * UserDetails normalUser=User .withUsername("abinaya")
		 * .password(passwordEncoder().encode("password") .roles("NORMAL") .build();
		 * UserDetails adminUser=User .withUsername("abinaya1") .password("password")
		 * .roles("ADMIN") .build(); return new InMemoryUserDetailsManager
		 * (normalUser,adminUser);
		 */
		return new CustomUserDetailService();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpsecurity) {
		httpSecurity.csrf().disable().authorizeHttpRequests()
				// .requestMatchers("/home/admin")
				/*
				 * .hasRole("ADMIN") .requestMatchers("/home/normal") .hasRole("NORMAL")
				 * .requestMatchers("/home/public")
				 */
				// .permitAll()
				.anyRequest().authenticated().and().formLogin();
		return httpSecurity.build();
	}

}
