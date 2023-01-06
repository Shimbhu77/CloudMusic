package com.CloudMusic.Model.DTO;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.CloudMusic.Model.Category;
import com.CloudMusic.Model.Gender;
import com.CloudMusic.Model.Singer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO1 {
	
	@Size(min = 3 , max= 32 ,message = "Enter song  name which has at least three characters and maximum 32 characters")
	private String name;
	
	@Size(min = 3 , max= 100 ,message = "Enter Song Description which has at least three characters and maximum 100 characters ")
	private String description;
	
	private String category;
	
	private List<String> singers  = new LinkedList<>();
}
