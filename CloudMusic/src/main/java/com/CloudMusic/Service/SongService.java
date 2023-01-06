package com.CloudMusic.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.CloudMusic.Exceptions.SongException;
import com.CloudMusic.Model.Song;
import com.CloudMusic.Model.DTO.SongDTO1;
import com.CloudMusic.Model.DTO.SongDTO2;
import com.CloudMusic.Model.DTO.SongDTO3;

public interface SongService {

	public Song uploadSong(SongDTO1 dto,MultipartFile file) throws SongException, IllegalStateException, IOException;
	public Song updateSong(SongDTO2 dto) throws SongException;
	public Song deleteSong(SongDTO3 dto) throws SongException;
	public Song makeSongPrivate(SongDTO3 dto) throws SongException;
	public List<Song> viewAllSongs() throws SongException;
	public byte[] viewSong(String name) throws SongException, IOException;
	
}
