package com.CloudMusic.ServiceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudMusic.Exceptions.ChennalException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Chennal;
import com.CloudMusic.Model.User;
import com.CloudMusic.Model.DTO.ChennalDTO1;
import com.CloudMusic.Repository.ChennalDao;
import com.CloudMusic.Repository.UserDao;
import com.CloudMusic.Service.ChennalService;
import com.CloudMusic.Service.UserService;

@Service
public class ChennalServiceImpl implements ChennalService {

	@Autowired
	private ChennalDao chDao;
	
	@Autowired 
	private UserService uService;
	
	@Autowired
	private UserDao uDao;
	
	@Override
	public Chennal createChennal(ChennalDTO1 dto) throws ChennalException, UserException {
		
		Chennal chennal = new Chennal();
		
		User user = uService.getCurrentLoggedInUser();
		
		if(user.getChennal()!=null)
		{
			throw new ChennalException("You already have chennal.");
		}
		
		if(user==null)
		{
			throw new UserException("Please login first for creating chennal");
		}
		
		chennal.setChennalName(dto.getChennalName());
		chennal.setDescription(dto.getDescription());
		chennal.setCreationTime(LocalDateTime.now());
		chennal.setUpdateTime(LocalDateTime.now());
		chennal.setUser(user);
		
		user.setChennal(chennal);
		
		chDao.save(chennal);
		
		uDao.save(user);
		
		return chennal;
		
		
	}

	@Override
	public Chennal updateChennal(ChennalDTO1 dto) throws ChennalException, UserException {

		User user = uService.getCurrentLoggedInUser();
		
		if(user==null)
		{
			throw new UserException("Please login first for creating chennal");
		}
		
		Optional<Chennal> optchennal = chDao.findById(user.getChennal().getChannelId());
		
		if(optchennal.isPresent())
		{
			Chennal chennal = optchennal.get();
			chennal.setChennalName(dto.getChennalName());
			chennal.setDescription(dto.getDescription());
			chennal.setUpdateTime(LocalDateTime.now());
			
			return chDao.save(chennal);
		}
		
		throw new ChennalException("you don't have any chennal.");
		
	}

	@Override
	public Chennal deleteChennal(Integer id) throws ChennalException, UserException {
		
		User user = uService.getCurrentLoggedInUser();
		
		if(user==null)
		{
			throw new UserException("Please login first for creating chennal");
		}
		
		//Optional<Chennal> optchennal = chDao.findById(user.getChennal().getChannelId());
		
//		if(optchennal.isPresent())
//		{
//			Chennal chennal = optchennal.get();
//			
//			chDao.delete(chennal);
//			
//			return chennal;
//		}
		
		throw new ChennalException("you can't delete chennal.");
	}

	@Override
	public Chennal viewChennal(Integer id) throws ChennalException, UserException {
		

		User user = uService.getCurrentLoggedInUser();
		
		if(user==null)
		{
			throw new UserException("Please login first for creating chennal");
		}
		
		Optional<Chennal> optchennal = chDao.findById(user.getChennal().getChannelId());
		
		if(optchennal.isPresent())
		{
			Chennal chennal = optchennal.get();
			
			return chennal;
		}
		
		throw new ChennalException("you don't have any chennal.");
	}

}
