package com.CloudMusic.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudMusic.Exceptions.ReactionException;
import com.CloudMusic.Exceptions.SongException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Reaction;
import com.CloudMusic.Model.Song;
import com.CloudMusic.Model.User;
import com.CloudMusic.Repository.CategoryDao;
import com.CloudMusic.Repository.ChennalDao;
import com.CloudMusic.Repository.ReactionDao;
import com.CloudMusic.Repository.SingerDao;
import com.CloudMusic.Repository.SongDao;
import com.CloudMusic.Repository.UserDao;
import com.CloudMusic.Service.ReactionService;
import com.CloudMusic.Service.UserService;

@Service
public class ReactionServiceImpl implements ReactionService {

	@Autowired
	private SongDao songDao;
	
	@Autowired
	private ReactionDao reactionDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public String likeSong(Integer songId) throws ReactionException, UserException, SongException {
		
		User user = userService.getCurrentLoggedInUser();
		
		if(user==null)
		{
			throw new UserException("please login first for like the song.");
		}
		
		Optional<Song> optSong = songDao.findById(songId);
		
		
		
		if(optSong.isPresent())
		{
		   Song song  = optSong.get();
		   
		   if(user.getReaction()!=null)
		   {

			  // System.out.println("+++++++++++++++++++++++++++++");
			   for(Song s : user.getReaction().getSongs())
			   {
				   if(s.getSongId()==song.getSongId())
				   {
					//   System.out.println("*** user already like ************************");
					   throw new ReactionException("Song already liked.");
				   }
			   }
		
		   }
		 
		   
		   int likes = song.getLikes();
		   
		   likes++;
		   
		   song.setLikes(likes);
		   Reaction reaction;
		   if(user.getReaction()==null)
		   {
			   reaction = new Reaction();
			   
			   reaction.setLikeSong(true);
			   reaction.setUserId(user.getUserId());
			   reaction.getSongs().add(song);
			   reaction.setUser(user);
		   }
		   else
		   {
			   reaction = user.getReaction();
			   reaction.getSongs().add(song);
		   }
		   
		   
		   
		   songDao.save(song);
		   
		   user.setReaction(reaction);
		   userDao.save(user);
		   
		   reactionDao.save(reaction);
		   
		  
		   
		   return user.getFirstName()+" is like the song "+song.getName();
		   
			
		}
		
		throw new SongException("Song not found with this id : "+songId);
	}

	@Override
	public String dislikeSong(Integer songId) throws ReactionException, UserException, SongException {
		
		User user = userService.getCurrentLoggedInUser();
		
		if(user==null)
		{
			throw new UserException("please login first for dislike the song.");
		}
		
		Optional<Song> optSong = songDao.findById(songId);
		
		if(optSong.isPresent())
		{
		   Song song  = optSong.get();
		   
		   if(user.getReaction()!=null)
		   {
			   int count=0;

			   //System.out.println("+++++++++++++++++++++++++++++");
			   for(Song s : user.getReaction().getSongs())
			   {
				   if(s.getSongId()!=song.getSongId())
				   {
					   count++;
//					   
				   }
			   }
			   
			   if(count==user.getReaction().getSongs().size())
			   {
//				   System.out.println("*** user already dislike ************************");
				   throw new ReactionException("Song already disliked.");
			   }
		
		   }
		   else
		   {
			   throw new ReactionException("you are not liking any song.");
		   }
		   
		   int likes = song.getLikes();
		   
		   likes--;
		   
		   song.setLikes(likes);
		   
		   Reaction reaction = user.getReaction();
		   
		  // reaction.setLikeSong(false);
		 //  reaction.setUserId(user.getUserId());
		   List<Song> songs = reaction.getSongs();
		   int ind =0;
		   for(Song s: songs)
		   {
			   if(s.getSongId()==song.getSongId())
			   {
				   break;
			   }
			   else
			   {
				   ind++;
			   }
		   }
		   
		   songs.remove(ind);
		   
		   
		   
		   songDao.save(song);
		   
		   reactionDao.save(reaction);
		   
		   return user.getFirstName()+" is dislike the song "+song.getName();
		   
			
		}
		
		throw new SongException("Song not found with this id : "+songId);
	}

	@Override
	public List<Song> viewAlllikeSongList() throws ReactionException, UserException {
		
 
		User user = userService.getCurrentLoggedInUser();
		
		if(user==null)
		{
			throw new UserException("please login first for dislike the song.");
		}
		
		Reaction reaction = user.getReaction();
		
		List<Song> songs = reaction.getSongs();
		
		return songs;
		
	}

}
