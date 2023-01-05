package com.CloudMusic.Model.DTO;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.CloudMusic.Model.Gender;
import com.CloudMusic.Model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO1 {

	@Column(unique = true)
	@NotBlank(message = "this email is already registered with other user. ")
	@Email(message = "Enter valid Email address.")
	private String email;
	
	@Pattern(regexp = "^[a-zA-Z]{3,12}$",
            message = "username must be of 3 to 12 length with no special characters or numbers")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-Z]{3,12}$",
            message = "username must be of 3 to 12 length with no special characters or numbers")
	private String lastName;
	
//	@NotBlank(message= "Enter valid Gender Male,Female or other")
	private Gender gender;
	
	@NotBlank
	private String role;
	
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&#]).{6,32}$",
//            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
//	@Size(min = 6,max = 12,message = "password should have 6 to  12  characters")
	private String password;
}
