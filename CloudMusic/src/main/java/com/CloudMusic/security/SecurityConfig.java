package com.CloudMusic.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
    SecurityFilterChain mySecurity(HttpSecurity http) throws Exception
	{
		http.headers().frameOptions().sameOrigin().and().authorizeHttpRequests( (auth) ->
		  auth.antMatchers("/cloudmusic/home/update-account","/cloudmusic/home/update-password","/cloudmusic/user/portal","/cloudmusic/home/view-my-account").authenticated()
		  .antMatchers("/cloudmusic/admin/portal").hasRole("Admin")
		  .antMatchers("/cloudmusic/home/**","/cloudmusic/developer/**").authenticated()
		  .antMatchers("/cloudmusic/home","/cloudmusic/user/register","/music/**").permitAll()
				).csrf().disable().httpBasic();
		
		return http.build();
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
