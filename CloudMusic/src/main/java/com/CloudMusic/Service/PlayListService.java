package com.CloudMusic.Service;

import java.util.List;

import com.CloudMusic.Exceptions.CommentException;
import com.CloudMusic.Exceptions.PlayListException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Comment;
import com.CloudMusic.Model.PlayList;
import com.CloudMusic.Model.DTO.CommentDTO1;
import com.CloudMusic.Model.DTO.CommentDTO2;
import com.CloudMusic.Model.DTO.PlayListDTO1;
import com.CloudMusic.Model.DTO.PlayListDTO2;
import com.CloudMusic.Model.DTO.PlayListDTO3;

public interface PlayListService {

	public PlayList addPlayList(PlayListDTO1 dto ) throws PlayListException, UserException;
	public PlayList updatePlayList(PlayListDTO2 dto ) throws PlayListException, UserException;
	public PlayList updatePlayListName(PlayListDTO3 dto ) throws PlayListException, UserException;
	public PlayList deletePlayList(Integer id) throws PlayListException, UserException;
	public PlayList viewPlayListById(Integer id) throws PlayListException ,UserException;
	public List<PlayList> viewAllPlayList() throws PlayListException, UserException;
}
