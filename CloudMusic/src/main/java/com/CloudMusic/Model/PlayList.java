package com.CloudMusic.Model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class PlayList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer playListId;
	
    private String playListName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Song> songs = new LinkedList<>();
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
}
