package com.CloudMusic.ServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CloudMusic.Exceptions.SongException;
import com.CloudMusic.Model.Category;
import com.CloudMusic.Model.Singer;
import com.CloudMusic.Model.Song;
import com.CloudMusic.Model.DTO.SongDTO1;
import com.CloudMusic.Model.DTO.SongDTO2;
import com.CloudMusic.Model.DTO.SongDTO3;
import com.CloudMusic.Repository.CategoryDao;
import com.CloudMusic.Repository.SingerDao;
import com.CloudMusic.Repository.SongDao;
import com.CloudMusic.Service.SongService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	private SongDao songDao;
	
	@Autowired
	private SingerDao singerDao;
	
	@Autowired
	private CategoryDao cDao;
	
	@Override
	public Song uploadSong(SongDTO1 dto ,MultipartFile file) throws SongException, IllegalStateException, IOException {
		
		
		File f = new File("CloudMusicDatabase");
		
		if(!f.exists())
		{
		    f.mkdir();
		}
		
		String filePath = f.getAbsolutePath() + File.separator + file.getOriginalFilename();
		
		file.transferTo(new File(filePath));

		
		Category category  = cDao.findByTitle(dto.getCategory());
		
		List<Singer> singers =  new ArrayList<>();
		
		for(String str : dto.getSingers())
		{
			Singer singer =singerDao.findByFullName(str);
			singers.add(singer);
		}
		
		
//		System.out.println("*************************** "+f.getAbsolutePath());
//		System.out.println("*************************** "+f.getPath());
//		System.out.println("************==========********* "+filePath);
//		
//		System.out.println("+++++++++++++++"+file.getContentType());
//		System.out.println("================="+file.getOriginalFilename());
		
		Song newsong = songDao.save(Song.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.category(category)
				.description(dto.getDescription())
				.views(0)
				.singers(singers)
				.filePath(filePath).build());
		
		
		if(newsong != null)
		{
//			
//			for(String str : dto.getSingers())
//			{
//				Singer singer =singerDao.findByFullName(str);
//				Set<Song> songsList = singer.getSongs().add(newsong);
//				
//			}
			
			return newsong;
		}
		
		throw new SongException("Unable to upload song, some technical error.");
		
	}

	@Override
	public Song updateSong(SongDTO2 dto) throws SongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song deleteSong(SongDTO3 dto) throws SongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song makeSongPrivate(SongDTO3 dto) throws SongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> viewAllSongs() throws SongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] viewSong(String name) throws SongException, IOException {
		
		Song song = songDao.findByName(name);
		
		String filePath = song.getFilePath();
		
		byte[] file = Files.readAllBytes(new File(filePath).toPath());
		
		return file;
	}

}
