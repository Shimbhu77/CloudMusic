package com.CloudMusic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CloudMusic.Model.Singer;

public interface SingerDao extends JpaRepository<Singer, Integer>{

}
