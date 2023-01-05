package com.CloudMusic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CloudMusic.Model.PlayList;

@Repository
public interface PlayListDao extends JpaRepository<PlayList, Integer> {

}
