package com.CloudMusic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CloudMusic.Model.Comment;

public interface CommentDao extends JpaRepository<Comment, Integer> {

}
