package com.CloudMusic.Model.DTO;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO2 {

	private Integer categoryId;
	
	@Size(min = 3 , max= 32 ,message = "Enter Category name which has at least three characters and maximum 32 characters")
	private String title;
	
	@Size(min = 3 , max= 100 ,message = "Enter Category description which has at least three characters and maximum 100 characters")
	private String description;
}
