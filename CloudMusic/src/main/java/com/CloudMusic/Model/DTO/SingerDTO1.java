package com.CloudMusic.Model.DTO;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingerDTO1 {

	@Size(min = 3 , max= 32 ,message = "Enter singer  name which has at least three characters and maximum 32 characters")
	private String fullName;
	
	@Size(min = 3 , max= 100 ,message = "Enter Singer Description which has at least three characters and maximum 100 characters ")
	private String bio;
}
