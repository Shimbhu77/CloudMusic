package com.CloudMusic.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.User;
import com.CloudMusic.Model.DTO.UserDTO1;
import com.CloudMusic.Model.DTO.UserDTO2;
import com.CloudMusic.Model.DTO.UserDTO3;
import com.CloudMusic.Repository.UserDao;
import com.CloudMusic.Service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao uDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User registerUser(UserDTO1 userdto ) throws UserException {
		
		User user = new User();
		
		user.setEmail(userdto.getEmail());
		
		user.setFirstName(userdto.getFirstName());
		
		user.setLastName(userdto.getLastName());
		
		user.setRole(userdto.getRole());
		
		user.setPassword(passwordEncoder.encode(userdto.getPassword()));
		
		user.setGender(userdto.getGender());
		
		System.out.println(user.toString());
		
		return uDao.save(user);
	}


	
	@Override
	public User updateMyAccount(UserDTO3 userdto) throws UserException {
	
		User user = getCurrentLoggedInUser();

		user.setFirstName(userdto.getFirstName());
		
		user.setLastName(userdto.getLastName());
		
		user.setGender(userdto.getGender());

		return uDao.save(user);
	}



	@Override
	public User getCurrentLoggedInUser() throws UserException {
		
       SecurityContext sc  = SecurityContextHolder.getContext();
		
		Authentication auth  = sc.getAuthentication();
		
		String email = auth.getName();
		
		User user = uDao.findByEmail(email);
		
		return user;
	}



	@Override
	public User updateMyPassword(UserDTO2 userdto) throws UserException {
		
		User user = getCurrentLoggedInUser();
		
        user.setPassword(passwordEncoder.encode(userdto.getPassword()));
		
        return uDao.save(user);
	}

}
