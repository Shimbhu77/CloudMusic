package com.CloudMusic.Service;

import java.util.List;

import com.CloudMusic.Exceptions.CategoryException;
import com.CloudMusic.Model.Category;
import com.CloudMusic.Model.DTO.CategoryDTO1;
import com.CloudMusic.Model.DTO.CategoryDTO2;
import com.CloudMusic.Model.DTO.CategoryDTO3;

public interface CategoryService {

	public Category addCategory(CategoryDTO1 dto ) throws CategoryException;
	public Category updateCategory(CategoryDTO2 dto ) throws CategoryException;
	public Category deleteCategory(Integer id ) throws CategoryException;
	public Category viewCategoryById(Integer id ) throws CategoryException;
	public List<Category> viewAllCategory() throws CategoryException;
}
