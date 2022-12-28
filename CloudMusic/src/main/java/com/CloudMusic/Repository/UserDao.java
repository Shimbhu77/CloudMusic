package com.CloudMusic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CloudMusic.Model.User;

public interface UserDao  extends JpaRepository<User, Integer>{

}
