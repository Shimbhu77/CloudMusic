package com.CloudMusic.Model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PlayList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer playListId;
	
	private Integer userId;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private Set<Song> songs = new LinkedHashSet<>();
	
}
