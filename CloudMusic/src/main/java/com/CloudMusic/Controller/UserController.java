package com.CloudMusic.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CloudMusic.Exceptions.ChennalException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Chennal;
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
	
	
	@PostMapping("/cloudmusic/user/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO1 userDto) throws UserException 
	{

		User user = uService.registerUser(userDto);
		
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
//	@GetMapping("/cloudmusic/user/logout")
//	public ResponseEntity<String> logoutUser() throws UserException 
//	{
//		
//		SecurityContext sc = SecurityContextHolder.getContext();
//		
//		 Authentication authentication =  sc.getAuthentication();
//		 
//		 sc.setAuthentication(null);
//		 
//		 String string = "logout secussfully.";
//		
//		return new ResponseEntity<String>(string,HttpStatus.CREATED);
//	}
	
	@PutMapping("/cloudmusic/home/update-account")
	public ResponseEntity<User> updateMyAccount(@Valid @RequestBody UserDTO3 userDto) throws UserException 
	{
		
		User user = uService.updateMyAccount(userDto);
		
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/cloudmusic/home/update-password")
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
	
	@GetMapping("/cloudmusic/home/chennal-subscribe/{id}")
	public ResponseEntity<String> subscribeChennal(@PathVariable("id") Integer id) throws ChennalException, UserException
	{

		String p = uService.subscribeChennal(id);
		
		return new ResponseEntity<String>(p,HttpStatus.OK);
	}
	
	@GetMapping("/cloudmusic/home/chennal-unsubscribe/{id}")
	public ResponseEntity<String> unsubscribeChennal(@PathVariable("id") Integer id) throws ChennalException, UserException
	{
		
		String p = uService.unsubscribeChennal(id);
		
		return new ResponseEntity<String>(p,HttpStatus.OK);
	}
	
//	@GetMapping("/cloudmusic/admin/portal")
//	public ResponseEntity<String> loginAdmin() 
//	{
//
//		String p = "Welcome to CloudMusic Admin portal";
//		
//		return new ResponseEntity<String>(p,HttpStatus.OK);
//	}
	
	@GetMapping("/cloudmusic/home/view-All-chennals")
	public ResponseEntity<List<Chennal>> viewAllChennals() throws UserException, ChennalException 
	{
		
		List<Chennal> chennals = uService.allChennals();
		
		return new ResponseEntity<List<Chennal>>(chennals,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/music/view-All-chennals")
	public ResponseEntity<List<Chennal>> viewAllChennalwithoutlogin() throws UserException, ChennalException 
	{
//		System.out.println("**********************  hello ");
//		System.out.println("**********************  hello ");
//		System.out.println("**********************  hello ");
//		System.out.println("**********************  hello ");
//		System.out.println("**********************  hello ");
//		System.out.println("**********************  hello ");
//		System.out.println("**********************  hello ");
//		System.out.println("**********************  hello ");
		List<Chennal> chennals = uService.allChennals();
		
		return new ResponseEntity<List<Chennal>>(chennals,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cloudmusic/home/view-my-subscribe-chennals")
	public ResponseEntity<List<Chennal>> viewMySubscribeChennals() throws UserException, ChennalException 
	{
		
		List<Chennal> chennals = uService.viewMySubscribeChennals();
		
		return new ResponseEntity<List<Chennal>>(chennals,HttpStatus.ACCEPTED);
	}
	
//	@GetMapping("/music/portal")
//	public ResponseEntity<String> loginUser()
//	{
////
////       SecurityContext sc =SecurityContextHolder.getContext();
////		
////		
////		Authentication auth=sc.getAuthentication();
////		
////		System.out.println("+++++++++++++++++++++++");
////		System.out.println("+++++++++++++++++++++++");
////		System.out.println("+++++++++++++++++++++++");
////		System.out.println("+++++++++++++++++++++++");
////		System.out.println("+++++++++++++++++++++++");
////		System.out.println("===========================");
//		
//		String p = "Welcome to CloudMusic user portal : ";//+auth.getName();
//		
//		
//		
//		return new ResponseEntity<String>(p,HttpStatus.OK);
//	}
}
