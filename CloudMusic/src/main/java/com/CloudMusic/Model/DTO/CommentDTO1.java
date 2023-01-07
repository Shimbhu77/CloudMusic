package com.CloudMusic.Model.DTO;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO1 {

	@Size(min = 3 , max= 100 ,message = "Enter comment  which has at least three characters and maximum 100 characters ")
	private String body;
	
	private Integer songId;
}
