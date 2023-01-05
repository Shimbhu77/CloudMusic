package com.CloudMusic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CloudMusic.Model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{

}
