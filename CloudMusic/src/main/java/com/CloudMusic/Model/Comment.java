package com.CloudMusic.Model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer commentId;
	
	@Size(min = 3 , max= 100 ,message = "Enter comment  which has at least three characters and maximum 100 characters ")
	private String body;
	
	private LocalDateTime commentTime;
	
	private LocalDateTime updateCommentTime;
	
	private Integer userId;
	
	private Integer songId;
	
}
