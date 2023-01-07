package com.CloudMusic.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CloudMusic.Exceptions.CategoryException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Category;
import com.CloudMusic.Model.User;
import com.CloudMusic.Model.DTO.CategoryDTO1;
import com.CloudMusic.Model.DTO.CategoryDTO2;
import com.CloudMusic.Model.DTO.UserDTO1;
import com.CloudMusic.Model.DTO.UserDTO2;
import com.CloudMusic.Model.DTO.UserDTO3;
import com.CloudMusic.Service.CategoryService;

@RestController
public class CategoryController {

	@Autowired 
	private CategoryService categoryService;
	
	@PostMapping("/cloudmusic/developer/categories")
	public ResponseEntity<Category> addCategory(@Valid @RequestBody CategoryDTO1 dto) throws  CategoryException 
	{

		Category category = categoryService.addCategory(dto);
		
		return new ResponseEntity<Category>(category,HttpStatus.CREATED);
	}
	
	@PutMapping("/cloudmusic/developer/categories")
	public ResponseEntity<Category> updateCategory(@Valid @RequestBody CategoryDTO2 dto) throws  CategoryException 
	{

		Category category = categoryService.updateCategory(dto);
		
		return new ResponseEntity<Category>(category,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/cloudmusic/developer/categories/{id}")
	public ResponseEntity<Category> deleteCategory(@PathVariable("id") Integer id) throws  CategoryException 
	{

		Category category = categoryService.deleteCategory(id);
		
		return new ResponseEntity<Category>(category,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cloudmusic/developer/categories/category/{id}")
	public ResponseEntity<Category> viewCategory(@PathVariable("id") Integer id) throws  CategoryException 
	{

		Category category = categoryService.viewCategoryById(id);
		
		return new ResponseEntity<Category>(category,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cloudmusic/developer/categories/viewAllcategories")
	public ResponseEntity<List<Category>> viewAllCategory() throws  CategoryException 
	{

		List<Category> category = categoryService.viewAllCategory();
		
		return new ResponseEntity<List<Category>>(category,HttpStatus.ACCEPTED);
	}
	
	
	
	
}
