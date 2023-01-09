package com.CloudMusic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CloudMusic.Model.Chennal;

@Repository
public interface ChennalDao  extends JpaRepository<Chennal, Integer>{

	
}
