package com.CloudMusic.Controller;

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
import com.CloudMusic.Exceptions.ChennalException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Category;
import com.CloudMusic.Model.Chennal;
import com.CloudMusic.Model.DTO.CategoryDTO1;
import com.CloudMusic.Model.DTO.CategoryDTO2;
import com.CloudMusic.Model.DTO.ChennalDTO1;
import com.CloudMusic.Service.ChennalService;

@RestController
public class ChennalController {

	@Autowired 
	private ChennalService chService;
	
	@PostMapping("/cloudmusic/developer/chennals")
	public ResponseEntity<Chennal> createChennal(@Valid @RequestBody ChennalDTO1 dto) throws  CategoryException, ChennalException, UserException 
	{

		Chennal chennal = chService.createChennal(dto);
		
		return new ResponseEntity<Chennal>(chennal,HttpStatus.CREATED);
	}
	
	@PutMapping("/cloudmusic/developer/chennals")
	public ResponseEntity<Chennal> updateChennal(@Valid @RequestBody ChennalDTO1 dto) throws  CategoryException, ChennalException, UserException 
	{

		Chennal chennal = chService.updateChennal(dto);
		
		return new ResponseEntity<Chennal>(chennal,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/cloudmusic/developer/chennals")
	public ResponseEntity<Chennal> deleteChennal() throws  CategoryException, ChennalException, UserException 
	{

		Chennal chennal = chService.deleteChennal();
		
		return new ResponseEntity<Chennal>(chennal,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cloudmusic/developer/chennals/chennal")
	public ResponseEntity<Chennal> viewChennal() throws  CategoryException, ChennalException, UserException 
	{

		Chennal chennal = chService.viewMyChennal();
		
		return new ResponseEntity<Chennal>(chennal,HttpStatus.ACCEPTED);
	}
}
