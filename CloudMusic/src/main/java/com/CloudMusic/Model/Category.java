package com.CloudMusic.Model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	
	@Size(min = 3 , max= 32 ,message = "Enter Category name which has at least three characters and maximum 32 characters")
	private String title;
	
	@Size(min = 3 , max= 100 ,message = "Enter Category description which has at least three characters and maximum 100 characters")
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	private Set<Song> songs = new LinkedHashSet<>();
}
