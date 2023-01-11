package com.CloudMusic.Model;

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
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Singer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer singerId;
	
	
	@Size(min = 3 , max= 32 ,message = "Enter singer  name which has at least three characters and maximum 32 characters")
	private String fullName;
	
	@Size(min = 3 , max= 100 ,message = "Enter Singer Description which has at least three characters and maximum 100 characters ")
	private String bio;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Song> songs  = new LinkedList<>();

	@Override
	public String toString() {
		return "Singer [singerId=" + singerId + ", fullName=" + fullName + ", bio=" + bio + "]";
	}
	
	
	
}
