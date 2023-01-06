package com.CloudMusic.Service;

import com.CloudMusic.Exceptions.CategoryException;
import com.CloudMusic.Model.Category;
import com.CloudMusic.Model.DTO.CategoryDTO1;
import com.CloudMusic.Model.DTO.CategoryDTO2;
import com.CloudMusic.Model.DTO.CategoryDTO3;

public interface CategoryService {

	public Category addCategory(CategoryDTO1 dto ) throws CategoryException;
	public Category updateCategory(CategoryDTO2 dto ) throws CategoryException;
	public Category deleteCategory(CategoryDTO3 dto ) throws CategoryException;
	public Category viewCategoryById(CategoryDTO3 dto ) throws CategoryException;
	public Category viewAllCategory() throws CategoryException;
}
