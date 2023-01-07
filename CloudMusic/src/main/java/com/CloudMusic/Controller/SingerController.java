package com.CloudMusic.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CloudMusic.Exceptions.CategoryException;
import com.CloudMusic.Exceptions.SingerException;
import com.CloudMusic.Model.Category;
import com.CloudMusic.Model.Singer;
import com.CloudMusic.Model.DTO.CategoryDTO1;
import com.CloudMusic.Model.DTO.CategoryDTO2;
import com.CloudMusic.Model.DTO.SingerDTO1;
import com.CloudMusic.Model.DTO.SingerDTO2;
import com.CloudMusic.Model.DTO.SongDTO1;
import com.CloudMusic.Service.CategoryService;
import com.CloudMusic.Service.SingerService;

@RestController
public class SingerController {

	@Autowired 
	private SingerService singerService;
	
	@PostMapping("/cloudmusic/developer/singers")
	public ResponseEntity<Singer> addSinger(@Valid @RequestBody SingerDTO1 dto) throws  SingerException 
	{

		Singer singer = singerService.addSinger(dto);
		
		return new ResponseEntity<Singer>(singer,HttpStatus.CREATED);
	}
	
	@PutMapping("/cloudmusic/developer/singers")
	public ResponseEntity<Singer> updateSinger(@Valid @RequestBody SingerDTO2 dto) throws  SingerException 
	{

		Singer singer = singerService.updateSinger(dto);
		
		return new ResponseEntity<Singer>(singer,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/cloudmusic/developer/singers/{id}")
	public ResponseEntity<Singer> deleteSinger(@PathVariable("id") Integer id) throws  SingerException 
	{

		Singer singer = singerService.deleteSinger(id);
		
		return new ResponseEntity<Singer>(singer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cloudmusic/developer/singers/singer/{id}")
	public ResponseEntity<Singer> viewSingerById(@PathVariable("id") Integer id) throws  SingerException 
	{

		Singer singer = singerService.viewSingerById(id);
		
		return new ResponseEntity<Singer>(singer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cloudmusic/developer/singers/view-all-singers")
	public ResponseEntity<List<Singer>> viewAllSingers() throws  SingerException 
	{

		List<Singer> singer = singerService.viewAllSinger();
		
		return new ResponseEntity<List<Singer>>(singer,HttpStatus.ACCEPTED);
	}
	
}
