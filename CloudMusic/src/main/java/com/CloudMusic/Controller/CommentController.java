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
import com.CloudMusic.Exceptions.SingerException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Comment;
import com.CloudMusic.Model.Singer;
import com.CloudMusic.Model.DTO.CommentDTO1;
import com.CloudMusic.Model.DTO.CommentDTO2;
import com.CloudMusic.Model.DTO.SingerDTO1;
import com.CloudMusic.Model.DTO.SingerDTO2;
import com.CloudMusic.Service.CommentService;
import com.CloudMusic.Service.SingerService;

@RestController
public class CommentController {

	@Autowired 
	private CommentService commentService;
	
	@PostMapping("/cloudmusic/developer/comments")
	public ResponseEntity<Comment> addComment(@Valid @RequestBody CommentDTO1 dto) throws  SingerException, CommentException, UserException 
	{

		Comment comment = commentService.addComment(dto);
		
		return new ResponseEntity<Comment>(comment,HttpStatus.CREATED);
	}
	
	@PutMapping("/cloudmusic/developer/comments")
	public ResponseEntity<Comment> updateComment(@Valid @RequestBody CommentDTO2 dto) throws  SingerException, CommentException, UserException 
	{

		Comment comment = commentService.updateComment(dto);
		
		return new ResponseEntity<Comment>(comment,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/cloudmusic/developer/comments/{id}")
	public ResponseEntity<Comment> deleteComment(@PathVariable("id") Integer id) throws  SingerException, CommentException, UserException 
	{

		Comment comment = commentService.deleteComment(id);
		
		return new ResponseEntity<Comment>(comment,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cloudmusic/developer/comments/comment/{id}")
	public ResponseEntity<Comment> viewCommentById(@PathVariable("id") Integer id) throws  SingerException, CommentException, UserException 
	{

		Comment comment = commentService.viewCommentById(id);
		
		return new ResponseEntity<Comment>(comment,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cloudmusic/developer/comments/view-all-comments")
	public ResponseEntity<List<Comment>> viewAllComments() throws  SingerException, CommentException, UserException 
	{

		List<Comment> comment = commentService.viewAllComment();
		
		return new ResponseEntity<List<Comment>>(comment,HttpStatus.ACCEPTED);
	}
}
