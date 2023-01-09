package com.CloudMusic.Service;

import java.util.List;

import com.CloudMusic.Exceptions.ReactionException;
import com.CloudMusic.Exceptions.SongException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Song;

public interface ReactionService {

	public String likeSong(Integer id) throws ReactionException, UserException, SongException;
	public String dislikeSong(Integer id) throws ReactionException ,UserException ,SongException;
	public List<Song> viewAlllikeSongList() throws ReactionException,UserException;
	
}
