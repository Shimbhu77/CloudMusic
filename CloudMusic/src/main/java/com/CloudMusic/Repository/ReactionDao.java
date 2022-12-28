package com.CloudMusic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CloudMusic.Model.Reaction;

public interface ReactionDao extends JpaRepository<Reaction, Integer> {

}
