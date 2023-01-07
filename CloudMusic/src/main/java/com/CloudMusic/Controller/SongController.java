package com.CloudMusic.Controller;

import java.io.IOException;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.CloudMusic.Exceptions.SongException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Song;
import com.CloudMusic.Model.User;
import com.CloudMusic.Model.DTO.SongDTO1;
import com.CloudMusic.Model.DTO.UserDTO1;
import com.CloudMusic.Service.SongService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SongController {

	@Autowired
	private SongService songService;
	
	@Autowired
	private ObjectMapper mapper;
	
	@PostMapping("/cloudmusic/home/user/upload-songs")
	public ResponseEntity<Song> uploadSong(@RequestParam("userData")  String data , @RequestParam("song") MultipartFile file) throws UserException, IllegalStateException, SongException, IOException 
	{

		SongDTO1 dto = mapper.readValue(data,SongDTO1.class);
		
		Song song  = songService.uploadSong(dto, file);
		
		return new ResponseEntity<Song>(song,HttpStatus.CREATED);
	}
	
	@GetMapping("/cloudmusic/home/user/song/{name}")
	public ResponseEntity<byte[]> viewSong(@PathVariable("name") String name)throws UserException, IllegalStateException, SongException, IOException 
	{

		byte[] song = songService.viewSong(name);
		
		System.out.println("song is written and view *************++++++++++++^^^^^^^^^^^^");
		
		 return ResponseEntity.status(HttpStatus.OK)
	                .contentType(MediaType.valueOf("video/mp4"))
	                .body(song);
	}
}
