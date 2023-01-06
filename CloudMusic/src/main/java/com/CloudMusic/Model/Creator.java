package com.CloudMusic.Model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Creator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer creatorId;
	
	private Integer userId;
	
	private LocalDateTime uploadTime;
	
	private LocalDateTime updateTime;
	
    private Integer songId;
	
	private Integer categoryId;
}
