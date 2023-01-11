package com.CloudMusic.Service;

import java.util.List;

import com.CloudMusic.Exceptions.ChennalException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Chennal;
import com.CloudMusic.Model.User;
import com.CloudMusic.Model.DTO.UserDTO1;
import com.CloudMusic.Model.DTO.UserDTO2;
import com.CloudMusic.Model.DTO.UserDTO3;

public interface UserService {

	public User registerUser(UserDTO1 user) throws UserException;
	public User getCurrentLoggedInUser() throws UserException;
	public User updateMyAccount(UserDTO3 user) throws UserException;
	public User updateMyPassword(UserDTO2 user) throws UserException;
	public String subscribeChennal(Integer id) throws ChennalException, UserException;
	public String unsubscribeChennal(Integer id) throws ChennalException,UserException;
	public List<Chennal> allChennals() throws ChennalException,UserException;
	
}
