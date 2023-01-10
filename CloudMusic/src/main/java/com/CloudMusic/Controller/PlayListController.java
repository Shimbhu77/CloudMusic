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

import com.CloudMusic.Exceptions.CommentException;
import com.CloudMusic.Exceptions.PlayListException;
import com.CloudMusic.Exceptions.SingerException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Comment;
import com.CloudMusic.Model.PlayList;
import com.CloudMusic.Model.Singer;
import com.CloudMusic.Model.DTO.CommentDTO1;
import com.CloudMusic.Model.DTO.CommentDTO2;
import com.CloudMusic.Model.DTO.PlayListDTO1;
import com.CloudMusic.Model.DTO.PlayListDTO2;
import com.CloudMusic.Model.DTO.PlayListDTO3;
import com.CloudMusic.Model.DTO.SingerDTO1;
import com.CloudMusic.Model.DTO.SingerDTO2;
import com.CloudMusic.Service.CommentService;
import com.CloudMusic.Service.PlayListService;
import com.CloudMusic.Service.SingerService;

@RestController
public class PlayListController {

	@Autowired 
	private PlayListService pService;
	
	@PostMapping("/cloudmusic/developer/playLists")
	public ResponseEntity<PlayList> addPlayList(@Valid @RequestBody PlayListDTO1  dto) throws   UserException, PlayListException 
	{

		PlayList playList = pService.addPlayList(dto);
		
		return new ResponseEntity<PlayList>(playList,HttpStatus.CREATED);
	}
	
	@PutMapping("/cloudmusic/developer/playLists")
	public ResponseEntity<PlayList> updatePlayList(@Valid @RequestBody PlayListDTO2 dto) throws  UserException, PlayListException 
	{

		PlayList playList = pService.updatePlayList(dto);
		
		return new ResponseEntity<PlayList>(playList,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/cloudmusic/developer/playLists/update-name")
	public ResponseEntity<PlayList> updatePlayList(@Valid @RequestBody PlayListDTO3 dto) throws  UserException, PlayListException 
	{
		
		PlayList playList = pService.updatePlayListName(dto);
		
		
		return new ResponseEntity<PlayList>(playList,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/cloudmusic/developer/playLists/{id}")
	public ResponseEntity<PlayList> deletePlayList(@PathVariable("id") Integer id) throws   UserException, PlayListException 
	{

		PlayList playList = pService.deletePlayList(id);
		
		return new ResponseEntity<PlayList>(playList,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cloudmusic/developer/playLists/playList/{id}")
	public ResponseEntity<PlayList> viewPlayListById(@PathVariable("id") Integer id) throws   UserException, PlayListException 
	{

		PlayList playList = pService.viewPlayListById(id);
		
		return new ResponseEntity<PlayList>(playList,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cloudmusic/developer/playLists/view-all-playLists")
	public ResponseEntity<List<PlayList>> viewAllPlayLists() throws   UserException, PlayListException 
	{

		List<PlayList> playList = pService.viewAllPlayList();
		
		return new ResponseEntity<List<PlayList>>(playList,HttpStatus.ACCEPTED);
	}
}
