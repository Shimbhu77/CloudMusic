package com.CloudMusic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CloudMusic.Model.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
