package com.CloudMusic.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CloudMusic.Model.Reaction;

public interface ReactionDao extends JpaRepository<Reaction, Integer> {

	public Reaction findByUserId(Integer userId);
}
