package com.CloudMusic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CloudMusic.Model.Song;

@Repository
public interface SongDao extends JpaRepository<Song, Integer>{

}
