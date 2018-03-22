package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.CategoryDTO;
import com.infotel.formation.Mapper.CategoryMapper;
import com.infotel.formation.entity.Category;
import com.infotel.formation.exception.ServiceException;
import com.infotel.formation.interfaces.CategoryService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;

@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	CategoryMapper mapper;

	@GetMapping(value = "/category/get")
	public Resultat getCategories() {
		Resultat res = new Resultat();
		try {
			List<CategoryDTO> viewCategories = new ArrayList<CategoryDTO>();

			List<Category> categories = categoryService.getCategories();

			for (Category category : categories) {
				viewCategories.add(mapper.mapIntoEditorDTO(category));
			}
			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(viewCategories);
		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PutMapping(value = "/category/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat addBook(@RequestBody CategoryDTO categoryDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			categoryService.insertCategory(mapper.mapIntoCategory(categoryDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(categoryDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PostMapping(value = "/category/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat updateBook(@RequestBody CategoryDTO categoryDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			categoryService.updateCategory(mapper.mapIntoCategory(categoryDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.UPDATE_SUCCESS);
			res.setPayload(categoryDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}

	@DeleteMapping(value = "/category/delete", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat deleteBook(@RequestBody CategoryDTO categoryDTO) {
		Resultat res = new Resultat();
		try {
			categoryService.deleteCategory(categoryService.getCategoryById(categoryDTO.getCategory_id()));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.DELETE_SUCCESS);
			res.setPayload(categoryDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}
}
