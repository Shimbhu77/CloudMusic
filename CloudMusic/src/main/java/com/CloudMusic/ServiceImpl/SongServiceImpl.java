package com.CloudMusic.ServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CloudMusic.Exceptions.SongException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Category;
import com.CloudMusic.Model.Chennal;
import com.CloudMusic.Model.Singer;
import com.CloudMusic.Model.Song;
import com.CloudMusic.Model.User;
import com.CloudMusic.Model.DTO.SongDTO1;
import com.CloudMusic.Model.DTO.SongDTO2;
import com.CloudMusic.Model.DTO.SongDTO3;
import com.CloudMusic.Repository.CategoryDao;
import com.CloudMusic.Repository.ChennalDao;
import com.CloudMusic.Repository.SingerDao;
import com.CloudMusic.Repository.SongDao;
import com.CloudMusic.Repository.UserDao;
import com.CloudMusic.Service.SongService;
import com.CloudMusic.Service.UserService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	private SongDao songDao;
	
	@Autowired
	private SingerDao singerDao;
	
	@Autowired
	private CategoryDao cDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ChennalDao chennalDao;
	
	@Override
	public Song uploadSong(SongDTO1 dto ,MultipartFile file) throws SongException, IllegalStateException, IOException, UserException {
		
		User user = userService.getCurrentLoggedInUser();
		
		if(user.getChennal()==null)
		{
			throw new SongException("first create Chennal after you can upload song.");
		}
		
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
		
		
		Song newsong = songDao.save(Song.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.category(category)
				.description(dto.getDescription())
				.views(0)
				.likes(0)
				.singers(singers)
				.filePath(filePath)
				.chennal(user.getChennal())
				.updateTime(LocalDateTime.now())
				.uploadTime(LocalDateTime.now())
				.build());
		
		
		if(newsong != null)
		{
			System.out.println(singers);
			ListIterator<Singer> listItr = singers.listIterator();
			
			while(listItr.hasNext())
			{
//				Singer s = listItr.next();
				
				listItr.next().getSongs().add(newsong);

//				s.getSongs().add(newsong);
//				
//				singerDao.save(s);
				
			}
			
//			for(Singer s : singers)
//			{
////				System.out.println(s.toString());
//				s.getSongs().add(newsong);
//				
//				singerDao.save(s);
//			}
			
			category.getSongs().add(newsong);
			
			cDao.save(category);
			
			Chennal ch = user.getChennal() ;
			ch.getSongs().add(newsong);
			
			chennalDao.save(ch);
			
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
	public Song deleteSong(Integer id) throws SongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song makeSongPrivate(Integer id) throws SongException {
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
		
		if(song!=null)
		{
		
			String filePath = song.getFilePath();
			
			int views = song.getViews();
			
			views++;
			
			song.setViews(views);
			
			songDao.save(song);
			
			
			byte[] file = Files.readAllBytes(new File(filePath).toPath());
			
			return file;
		}
		
		throw new SongException("No song found with this nane : "+name);
	}

}
