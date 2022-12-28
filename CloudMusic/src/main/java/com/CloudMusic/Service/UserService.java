package com.CloudMusic.Service;

import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.User;
import com.CloudMusic.Model.DTO.UserDTO1;
import com.CloudMusic.Model.DTO.UserDTO2;
import com.CloudMusic.Model.DTO.UserDTO3;

public interface UserService {

	public User registerUser(UserDTO1 user) throws UserException;
	public User loginUser(UserDTO2 user) throws UserException;
	public User viewMyAccount() throws UserException;
	public User updateMyAccount(UserDTO3 user) throws UserException;
}
