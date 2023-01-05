package com.CloudMusic.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.User;
import com.CloudMusic.Model.DTO.UserDTO1;
import com.CloudMusic.Model.DTO.UserDTO2;
import com.CloudMusic.Model.DTO.UserDTO3;
import com.CloudMusic.Repository.UserDao;
import com.CloudMusic.Service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private UserDao uDao;
	
	@PostMapping("/cloudmusic/home/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO1 userDto) throws UserException 
	{

		User user = uService.registerUser(userDto);
		
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	@PostMapping("/cloudmusic/home/update-account")
	public ResponseEntity<User> updateMyAccount(@Valid @RequestBody UserDTO3 userDto) throws UserException 
	{
		
		User user = uService.updateMyAccount(userDto);
		
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/cloudmusic/home/update-password")
	public ResponseEntity<User> updateMyPassword(@Valid @RequestBody UserDTO2 userDto) throws UserException 
	{
		
		User user = uService.updateMyPassword(userDto);
		
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cloudmusic/home/view-my-account")
	public ResponseEntity<User> viewMyAccount() throws UserException 
	{
		
		User user = uService.getCurrentLoggedInUser();
		
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cloudmusic/home")
	public ResponseEntity<String> userWelcome()
	{

		String p = "Welcome to CloudMusic Website";
		
		return new ResponseEntity<String>(p,HttpStatus.OK);
	}
	
	@GetMapping("/cloudmusic/admin/portal")
	public ResponseEntity<String> loginAdmin() 
	{

		String p = "Welcome to CloudMusic Admin portal";
		
		return new ResponseEntity<String>(p,HttpStatus.OK);
	}
	
	
	@GetMapping("/cloudmusic/user/portal")
	public ResponseEntity<String> loginUser()
	{

       SecurityContext sc =SecurityContextHolder.getContext();
		
		
		Authentication auth=sc.getAuthentication();
		
		String p = "Welcome to CloudMusic user portal : "+auth.getName();
		
		
		
		return new ResponseEntity<String>(p,HttpStatus.OK);
	}
}
