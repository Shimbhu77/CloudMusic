package com.CloudMusic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CloudMusic.Model.Comment;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {

}
