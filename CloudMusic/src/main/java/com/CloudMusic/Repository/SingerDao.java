package com.CloudMusic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CloudMusic.Model.Singer;

@Repository
public interface SingerDao extends JpaRepository<Singer, Integer>{

	public Singer findByFullName(String fullName);
}
