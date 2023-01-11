package com.CloudMusic.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CloudMusic.Exceptions.ChennalException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Chennal;
import com.CloudMusic.Model.User;
import com.CloudMusic.Model.DTO.UserDTO1;
import com.CloudMusic.Model.DTO.UserDTO2;
import com.CloudMusic.Model.DTO.UserDTO3;
import com.CloudMusic.Repository.ChennalDao;
import com.CloudMusic.Repository.UserDao;
import com.CloudMusic.Service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao uDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ChennalDao chDao;
	
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



	@Override
	public String subscribeChennal(Integer id) throws ChennalException, UserException {
		
        User user = getCurrentLoggedInUser();
		
		if(user==null)
		{
			throw new UserException("please login first for  subscribe the song.");
		}
		
	    Optional<Chennal> opt = chDao.findById(id); 
	    
	    if(opt.isPresent())
	    {
	    	Chennal chennal = opt.get();
	    	
	        int subscribers = chennal.getSubscribers();
	        subscribers++;
	        chennal.setSubscribers(subscribers);
	        
	        user.getChennals().add(chennal);
	        
	        uDao.save(user);
	        
	        chDao.save(chennal);
	        
	        return user.getFirstName()+" subscribed the chennal "+chennal.getChennalName();
	    }
	    
	    throw new ChennalException("Chennal not found with this id : "+id);
		
	}



	@Override
	public String unsubscribeChennal(Integer id) throws ChennalException, UserException {
		
		 User user = getCurrentLoggedInUser();
			
			if(user==null)
			{
				throw new UserException("please login first for  unsubscribe the song.");
			}
			
		    Optional<Chennal> opt = chDao.findById(id); 
		    
		    if(opt.isPresent())
		    {
		    	Chennal chennal = opt.get();
		    	
		        int subscribers = chennal.getSubscribers();
		        subscribers--;
		        chennal.setSubscribers(subscribers);
		        
		        List<Chennal> chs = user.getChennals();
		        
		        int ind=0;
		        
		        for(Chennal ch: chs)
		        {
		        	if(ch.getChannelId()!=id)
		        	{
		        		ind++;
		        	}
		        	else
		        	{
		        		break;
		        	}
		        }
		        
		        chs.remove(ind);
		        
		        uDao.save(user);
		        
		        chDao.save(chennal);
		        
		        return user.getFirstName()+" unsubscribed the chennal "+chennal.getChennalName();
		    }
		    
		    throw new ChennalException("Chennal not found with this id : "+id);

	}



	@Override
	public List<Chennal> allChennals() throws ChennalException, UserException {
		
		User user = getCurrentLoggedInUser();
		
		if(user==null)
		{
			throw new UserException("please login first for viewing the songs.");
		}
		
		List<Chennal> chs = chDao.findAll();
		
		return chs;
	}

}
