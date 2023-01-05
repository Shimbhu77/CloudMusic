package com.CloudMusic.Model.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.CloudMusic.Model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO2 {

//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&#]).{6,32}$",
//            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
//	@Size(min = 6,max = 12,message = "password should have 6 to  12  characters")
	private String password;
}
