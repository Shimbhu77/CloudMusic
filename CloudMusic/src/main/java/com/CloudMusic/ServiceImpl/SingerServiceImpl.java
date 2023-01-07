package com.CloudMusic.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudMusic.Exceptions.SingerException;
import com.CloudMusic.Model.Singer;
import com.CloudMusic.Model.DTO.SingerDTO1;
import com.CloudMusic.Model.DTO.SingerDTO2;
import com.CloudMusic.Model.DTO.SingerDTO3;
import com.CloudMusic.Repository.SingerDao;
import com.CloudMusic.Service.SingerService;

@Service
public class SingerServiceImpl implements SingerService{

	@Autowired 
	private  SingerDao singerDao;
	
	@Override
	public Singer addSinger(SingerDTO1 dto) throws SingerException {
		
		Singer singer = new Singer();
		
		singer.setBio(dto.getBio());
		singer.setFullName(dto.getFullName());
		
		return singerDao.save(singer);
	}

	@Override
	public Singer updateSinger(SingerDTO2 dto) throws SingerException {
		
		Optional<Singer> optSinger = singerDao.findById(dto.getSingerId());
		
		if(optSinger.isPresent())
		{
			Singer singer = optSinger.get();
			
			singer.setFullName(dto.getBio());
			singer.setBio(dto.getBio());
			
			return singerDao.save(singer);
		}
		
		throw new SingerException("Singer not found with this id : "+dto.getSingerId());
	}

	@Override
	public Singer deleteSinger(Integer id) throws SingerException {
		

		Optional<Singer> optSinger = singerDao.findById(id);
		
		if(optSinger.isPresent())
		{
			Singer singer = optSinger.get();
			
			singerDao.delete(singer);
			
			return singer;
		}
		
		throw new SingerException("Singer not found with this id : "+id);
	}

	@Override
	public Singer viewSingerById(Integer id) throws SingerException {
		
        Optional<Singer> optSinger = singerDao.findById(id);
		
		if(optSinger.isPresent())
		{
			Singer singer = optSinger.get();
			
			return singer;
		}
		
		throw new SingerException("Singer not found with this id : "+id);
	}

	@Override
	public List<Singer> viewAllSinger() throws SingerException {
		
		
		List<Singer> singers = singerDao.findAll();
		
		return singers;
		
	}

}
