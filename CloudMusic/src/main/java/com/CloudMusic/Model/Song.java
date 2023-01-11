package com.CloudMusic.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer songId;
	
	//@Size(min = 1 , max= 8 ,message = "Enter type Mp3 or Mp4")
	@Column(length = 1000)
	private String type;
	
	@Size(min = 3 , max= 255 ,message = "Enter song  name which has at least three characters and maximum 32 characters")
	private String name;
	
	@Size(min = 3 , max= 100 ,message = "Enter Song Description which has at least three characters and maximum 100 characters ")
	private String description;
	
	private Integer views;
	
	private Integer likes;
	
//	@Lob
//    @Column(name = "songdata", length = 1000)
//    private byte[] songData;
	
	private String filePath;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Singer> singers  = new LinkedList<>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne(cascade =  CascadeType.ALL)
	private Chennal chennal;
	
    private LocalDateTime uploadTime;
	
	private LocalDateTime updateTime;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<PlayList> playlists = new ArrayList<>();
	
}
