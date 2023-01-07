package com.CloudMusic.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CloudMusic.Exceptions.CategoryException;
import com.CloudMusic.Model.Category;
import com.CloudMusic.Model.DTO.CategoryDTO1;
import com.CloudMusic.Model.DTO.CategoryDTO2;
import com.CloudMusic.Model.DTO.CategoryDTO3;
import com.CloudMusic.Repository.CategoryDao;
import com.CloudMusic.Service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao cDao;
	
	
	@Override
	public Category addCategory(CategoryDTO1 dto) throws CategoryException {
		
		Category category = new Category();
		
		category.setTitle(dto.getTitle());
		category.setDescription(dto.getDescription());
		
		return cDao.save(category);
		
	}

	@Override
	public Category updateCategory(CategoryDTO2 dto) throws CategoryException {
		
		Optional<Category> optcategory = cDao.findById(dto.getCategoryId());
		
		if(optcategory.isPresent())
		{
			Category category = optcategory.get();
			
			category.setTitle(dto.getTitle());
			category.setDescription(dto.getDescription());
			
			return cDao.save(category);
		}
		
		throw new CategoryException("No category found with this id : "+dto.getCategoryId());
		
	}

	@Override
	public Category deleteCategory(Integer id) throws CategoryException {

		Optional<Category> optcategory = cDao.findById(id);
		
		if(optcategory.isPresent())
		{
			Category category = optcategory.get();
			
			cDao.delete(category);
			
			return category;
		}
		
		throw new CategoryException("No category found with this id : "+id);
	}

	@Override
	public Category viewCategoryById(Integer id) throws CategoryException {
		

		Optional<Category> optcategory = cDao.findById(id);
		
		if(optcategory.isPresent())
		{
			Category category = optcategory.get();
			
			return category;
		}
		
		throw new CategoryException("No category found with this id : "+id);
	}

	@Override
	public List<Category> viewAllCategory() throws CategoryException {
		
		List<Category> categories  = cDao.findAll();
		
		return categories;
		
	}

}
