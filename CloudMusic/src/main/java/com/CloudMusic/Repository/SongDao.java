package com.CloudMusic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CloudMusic.Model.Song;

public interface SongDao extends JpaRepository<Song, Integer>{

}
