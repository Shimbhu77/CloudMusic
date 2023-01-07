package com.CloudMusic.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudMusic.Exceptions.CommentException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Category;
import com.CloudMusic.Model.Comment;
import com.CloudMusic.Model.User;
import com.CloudMusic.Model.DTO.CommentDTO1;
import com.CloudMusic.Model.DTO.CommentDTO2;
import com.CloudMusic.Model.DTO.CommentDTO3;
import com.CloudMusic.Repository.CommentDao;
import com.CloudMusic.Service.CommentService;
import com.CloudMusic.Service.UserService;

@Service
public class CommentServiceImpl  implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	@Autowired 
	private UserService uService;

	@Override
	public Comment addComment(CommentDTO1 dto) throws CommentException, UserException {

		User user = uService.getCurrentLoggedInUser();
		
		if(user!=null)
		{
			
			Comment comment = new Comment();
			
			comment.setBody(dto.getBody());
			comment.setCommentTime(LocalDateTime.now());
			comment.setUpdateCommentTime(LocalDateTime.now());
			comment.setUserId(user.getUserId());
			comment.setSongId(dto.getSongId());
			
			return commentDao.save(comment);
			
		}
		
		throw new UserException("please login first for doing comment");
		
	}

	@Override
	public Comment updateComment(CommentDTO2 dto) throws CommentException, UserException {

		User user = uService.getCurrentLoggedInUser();
		
		if(user!=null)
		{
	
			Optional<Comment> comment = commentDao.findById(dto.getCommentId());
			 
			if(comment.isPresent())
			{
				if(user.getUserId()==comment.get().getUserId())
				{
					Comment com = comment.get();
					
					com.setBody(dto.getBody());
					com.setUpdateCommentTime(LocalDateTime.now());
					
					return commentDao.save(com);
					
				}
				else
				{
					throw new CommentException("you don't have authority to update this comment.");
				}
			}
			
			throw new CommentException("comment not found with this id : "+dto.getCommentId());
			
		}
		
		throw new UserException("please login first for updating comment");
	}

	@Override
	public Comment deleteComment(Integer id) throws CommentException, UserException {
		

		User user = uService.getCurrentLoggedInUser();
		
		if(user!=null)
		{
	
			Optional<Comment> comment = commentDao.findById(id);
			 
			if(comment.isPresent())
			{
				if(user.getUserId()==comment.get().getUserId())
				{
					Comment com = comment.get();
					
					commentDao.delete(com);
					
					return com;
					
				}
				else
				{
					throw new CommentException("you don't have authority to update this comment.");
				}
			}
			
			throw new CommentException("comment not found with this id : "+id);
			
		}
		
		throw new UserException("please login first for deleting comment");
	}

	@Override
	public Comment viewCommentById(Integer id) throws CommentException, UserException {
		
        User user = uService.getCurrentLoggedInUser();
		
		if(user!=null)
		{
	
			Optional<Comment> comment = commentDao.findById(id);
			 
			if(comment.isPresent())
			{
				if(user.getUserId()==comment.get().getUserId())
				{
					Comment com = comment.get();
					
					return com;
					
				}
				else
				{
					throw new CommentException("you don't have authority to update this comment.");
				}
			}
			
			throw new CommentException("comment not found with this id : "+id);
			
		}
		
		throw new UserException("please login first for viewing comment");
	}

	@Override
	public List<Comment> viewAllComment() throws CommentException, UserException {
		
		 User user = uService.getCurrentLoggedInUser();
			
			if(user!=null)
			{
		
				List<Comment> comments = commentDao.findAll();
				
				List<Comment> myComments = new ArrayList<>();
				
				for(Comment comment : comments)
				{
					if(comment.getUserId()==user.getUserId())
					   myComments.add(comment);
				}
				
				return myComments;
				
			}
			
			throw new UserException("please login first for viewing All comment");
	}
	
	
}
