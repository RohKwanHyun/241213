package com.example.demo.secu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests((auth) -> auth
					.requestMatchers("/", "/registForm", "/registProc").permitAll()
					.requestMatchers("/students/**").hasAnyRole("STUDENT", "TEACHER")
					.requestMatchers("/teacher/**").hasRole("TEACHER")
					.anyRequest().authenticated()
					);
		
		http
			.formLogin((auth) -> auth
					.loginPage("/loginForm")
					.loginProcessingUrl("/loginProc")
					.defaultSuccessUrl("/students/mypage")
					.failureUrl("/loginForm?error")
					.permitAll()
					);
		
		http
			.logout((auth) -> auth
					.logoutSuccessUrl("/")
					);
		
		return http.build();
	}
	
	
}
