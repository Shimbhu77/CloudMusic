package com.CloudMusic.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.CloudMusic.Exceptions.SongException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Song;
import com.CloudMusic.Model.DTO.SongDTO1;
import com.CloudMusic.Model.DTO.SongDTO2;
import com.CloudMusic.Model.DTO.SongDTO3;

public interface SongService {

	public Song uploadSong(SongDTO1 dto,MultipartFile file) throws SongException, IllegalStateException, IOException, UserException;
	public Song updateSong(SongDTO2 dto) throws SongException;
	public Song deleteSong(Integer id) throws SongException;
	public Song makeSongPrivate(Integer id) throws SongException;
	public List<Song> viewAllSongs() throws SongException;
	public List<Song> viewSongWithoutlogin() throws SongException, IOException;
	public byte[] viewSong(String name) throws SongException, IOException;
	
}
