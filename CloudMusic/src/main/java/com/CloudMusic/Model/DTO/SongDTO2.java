package com.CloudMusic.Model.DTO;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.validation.constraints.Size;

import com.CloudMusic.Model.Category;
import com.CloudMusic.Model.Singer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO2 {

	private Integer songId;
	
	@Size(min = 3 , max= 32 ,message = "Enter song  name which has at least three characters and maximum 32 characters")
	private String name;
	
	@Size(min = 3 , max= 100 ,message = "Enter Song Description which has at least three characters and maximum 100 characters ")
	private String description;
	
	private Category category;
	
	private Set<Singer> singers  = new LinkedHashSet<>();
}
