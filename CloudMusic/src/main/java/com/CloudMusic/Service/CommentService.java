package com.CloudMusic.Service;

import java.util.List;

import com.CloudMusic.Exceptions.CategoryException;
import com.CloudMusic.Exceptions.CommentException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Category;
import com.CloudMusic.Model.Comment;
import com.CloudMusic.Model.DTO.CategoryDTO1;
import com.CloudMusic.Model.DTO.CategoryDTO2;
import com.CloudMusic.Model.DTO.CategoryDTO3;
import com.CloudMusic.Model.DTO.CommentDTO1;
import com.CloudMusic.Model.DTO.CommentDTO2;
import com.CloudMusic.Model.DTO.CommentDTO3;

public interface CommentService {

	public Comment addComment(CommentDTO1 dto ) throws CommentException, UserException;
	public Comment updateComment(CommentDTO2 dto ) throws CommentException, UserException;
	public Comment deleteComment(Integer id) throws CommentException, UserException;
	public Comment viewCommentById(Integer id) throws CommentException ,UserException;
	public List<Comment> viewAllComment() throws CommentException, UserException;
}
