package com.CloudMusic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CloudMusic.Model.PlayList;

public interface PlayListDao extends JpaRepository<PlayList, Integer> {

}
