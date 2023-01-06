package com.CloudMusic.Model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reaction {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reactionId;
	
	private Boolean like;
	
	private Integer userId;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private Set<Song> songs = new LinkedHashSet<>();
	
}
