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
import com.CloudMusic.Exceptions.ReactionException;
import com.CloudMusic.Exceptions.SongException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Category;
import com.CloudMusic.Model.Reaction;
import com.CloudMusic.Model.Song;
import com.CloudMusic.Model.DTO.CategoryDTO1;
import com.CloudMusic.Model.DTO.CategoryDTO2;
import com.CloudMusic.Service.ReactionService;

@RestController
public class LikeController {

	@Autowired
	private ReactionService rService;
	
	@PostMapping("/cloudmusic/developer/reactions/{songId}")
	public ResponseEntity<String> likeSong(@PathVariable("songId") Integer songId) throws  ReactionException, UserException, SongException 
	{

		String string = rService.likeSong(songId);
		
		return new ResponseEntity<String>(string,HttpStatus.CREATED);
	}
	
	@PutMapping("/cloudmusic/developer/reactions/{songId}")
	public ResponseEntity<String> dislikeSong(@PathVariable("songId") Integer songId) throws  ReactionException, UserException, SongException 
	{

		String string = rService.removelikeSong(songId);
		
		return new ResponseEntity<String>(string,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cloudmusic/developer/reactions")
	public ResponseEntity<List<Song>> viewlikeSongList() throws   ReactionException, UserException 
	{

		List<Song> songs = rService.viewAlllikeSongList();
		
		return new ResponseEntity<List<Song>>(songs,HttpStatus.ACCEPTED);
	}
	
	
}
