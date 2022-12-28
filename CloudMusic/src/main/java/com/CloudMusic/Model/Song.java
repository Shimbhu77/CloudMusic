package com.CloudMusic.Model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer songId;
	
	@Size(min = 3 , max= 3 ,message = "Enter type Mp3 or Mp4")
	private String type;
	
	@Size(min = 3 , max= 32 ,message = "Enter song  name which has at least three characters and maximum 32 characters")
	private String title;
	
	@Size(min = 3 , max= 100 ,message = "Enter Song Description which has at least three characters and maximum 100 characters ")
	private String description;
	
	private Integer streamCount=0;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Singer> singers  = new LinkedHashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();
	
}
