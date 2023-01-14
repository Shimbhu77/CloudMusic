package com.CloudMusic.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudMusic.Exceptions.PlayListException;
import com.CloudMusic.Exceptions.SongException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.PlayList;
import com.CloudMusic.Model.Song;
import com.CloudMusic.Model.User;
import com.CloudMusic.Model.DTO.PlayListDTO1;
import com.CloudMusic.Model.DTO.PlayListDTO2;
import com.CloudMusic.Model.DTO.PlayListDTO3;
import com.CloudMusic.Repository.PlayListDao;
import com.CloudMusic.Repository.ReactionDao;
import com.CloudMusic.Repository.SongDao;
import com.CloudMusic.Repository.UserDao;
import com.CloudMusic.Service.PlayListService;
import com.CloudMusic.Service.UserService;

@Service
public class PlayListServiceImpl implements PlayListService {

	@Autowired
	private PlayListDao pDao;
	
	@Autowired
	private SongDao songDao;
	
	@Autowired
	private ReactionDao reactionDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public PlayList addPlayList(PlayListDTO1 dto) throws PlayListException, UserException {
		
	
		
        User user = userService.getCurrentLoggedInUser();
		
		if(user==null)
		{
			throw new UserException("please login first for like the song.");
		}
		
	    PlayList playList  = new PlayList();
		
		playList.setPlayListName(dto.getPlayListName());
		playList.setUser(user);
		
		user.getPlayLists().add(playList);
		
//		userDao.save(user);
		
		return pDao.save(playList);
		
		
	}

	@Override
	public PlayList updatePlayList(PlayListDTO2 dto) throws PlayListException, UserException {
		
		 User user = userService.getCurrentLoggedInUser();
			
			if(user==null)
			{
				throw new UserException("please login first for make the playlist");
			}
			
		    Optional<PlayList> playLists  = pDao.findById(dto.getPId());
		    
		    if(!playLists.isPresent())
		    {
		    	throw new PlayListException("first create playlist. because playlist not found with this id : "+dto.getPId());
		    }
		    else
		    {
		    	
    			 Optional<Song> song =songDao.findById(dto.getSongId());
    			 
    			 if(song.isPresent())
    			 {
    				 PlayList p = playLists.get();
    				 
    				    int count=0;
    			    	for(PlayList pl : user.getPlayLists())
    			    	{
    			    		if(pl.getPlayListId()!=p.getPlayListId())
    			    		{
    			    			count++;
    			    		}
    			    	}
    			    	
    			    	if(count==user.getPlayLists().size())
    			    	{
    			    		throw new PlayListException("you don't have authority to delete this playlist.");
    			    	}
    				 
    				 for(Song x : p.getSongs())
    				 {
    					 if(x.getSongId()==song.get().getSongId())
    					 {
    						 throw new PlayListException("Song already added in your playlist.");
    					 }
    				 }
    				 
    				 p.getSongs().add(song.get());
    				 
    				 return pDao.save(p);
    			 }
    			 else
    			 {
    				 throw new PlayListException("song not found with this id : "+dto.getSongId());
    			 }
		    	
	    	    
	    		
		    }
	}

	@Override
	public PlayList updatePlayListName(PlayListDTO3 dto) throws PlayListException, UserException {
		
		    User user = userService.getCurrentLoggedInUser();
			
			if(user==null)
			{
				throw new UserException("please login first for make the playlist");
			}
			
		    Optional<PlayList> playList  = pDao.findById(dto.getPId());
		    
		    if(playList.isPresent())
		    {
		    	int count=0;
		    	PlayList p = playList.get();
		    	for(PlayList pl : user.getPlayLists())
		    	{
		    		if(pl.getPlayListId()!=playList.get().getPlayListId())
		    		{
		    			count++;
		    		}
		    	}
		    	
		    	if(count==user.getPlayLists().size())
		    	{
		    		throw new PlayListException("you don't have authority to update this playlist.");
		    	}
		    	
		    	
		    	p.setPlayListName(dto.getPlayListName());
		    	
		    	return pDao.save(p);
		    }
		    else
		    {
		    	throw new PlayListException(" playlist not found with this id : "+dto.getPId());
		    }
	}

	@Override
	public PlayList deletePlayList(Integer id) throws PlayListException, UserException {
		
		User user = userService.getCurrentLoggedInUser();
		
		if(user==null)
		{
			throw new UserException("please login first for make the playlist");
		}
		
	    Optional<PlayList> playList  = pDao.findById(id);
	    
	    if(playList.isPresent())
	    {
	    	PlayList p = playList.get();
	    	int count=0;
	    	for(PlayList pl : user.getPlayLists())
	    	{
	    		if(pl.getPlayListId()!=playList.get().getPlayListId())
	    		{
	    			count++;
	    		}
	    	}
	    	
	    	if(count==user.getPlayLists().size())
	    	{
	    		throw new PlayListException("you don't have authority to delete this playlist.");
	    	}
	        
	    	List<PlayList> list = user.getPlayLists();
	    	int ind=0;
	    	for(PlayList pl : list )
	    	{
	    		if(pl.getPlayListId()!=p.getPlayListId())
	    		{
	    		
	    			ind++;
	    		}
	    		else
	    		{
	    			break;
	    		}
	    	}
	    	list.remove(ind);
	    	//pDao.delete(p);
	    	userDao.save(user);
	    	
	    	return p;
	    }
	    else
	    {
	    	throw new PlayListException(" playlist not found with this id : "+id);
	    }
	}

	@Override
	public PlayList viewPlayListById(Integer id) throws PlayListException, UserException {

		User user = userService.getCurrentLoggedInUser();
		
		if(user==null)
		{
			throw new UserException("please login first for make the playlist");
		}
		
	    Optional<PlayList> playList  = pDao.findById(id);
	    
	    if(playList.isPresent())
	    {
	    	PlayList p = playList.get();
	    	
	    	int count=0;
	    	for(PlayList pl : user.getPlayLists())
	    	{
	    		if(pl.getPlayListId()!=playList.get().getPlayListId())
	    		{
	    			count++;
	    		}
	    	}
	    	
	    	if(count==user.getPlayLists().size())
	    	{
	    		throw new PlayListException("you don't have authority to view this playlist.");
	    	}
	    	
	    	return p;
	    }
	    else
	    {
	    	throw new PlayListException(" playlist not found with this id : "+id);
	    }
	}

	@Override
	public List<PlayList> viewAllPlayList() throws PlayListException, UserException {

		User user = userService.getCurrentLoggedInUser();
		
		if(user==null)
		{
			throw new UserException("please login first for make the playlist");
		}
		 
		List<PlayList> list = user.getPlayLists();
		
		return list;
		
	}

}
