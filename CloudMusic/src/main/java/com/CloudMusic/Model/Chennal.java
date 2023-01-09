package com.CloudMusic.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Chennal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer channelId;
	
	@JsonIgnore
	@OneToOne
	private User user;
	
	private String chennalName;
	
	private String description;
	
	private LocalDateTime CreationTime;
	
	private LocalDateTime updateTime;
	
	@OneToMany
	private List<Song> songs = new ArrayList<>();

}
