package com.CloudMusic.Model.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.CloudMusic.Model.Gender;
import com.CloudMusic.Model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO3 {

	@Pattern(regexp = "^[a-zA-Z]{3,12}$",
            message = "username must be of 3 to 12 length with no special characters or numbers")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-Z]{3,12}$",
            message = "username must be of 3 to 12 length with no special characters or numbers")
	private String lastName;
	
	//@NotBlank(message= "Enter valid Gender Male,Female or other")
	private Gender gender;
}
