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

import com.infotel.formation.DTO.EditorDTO;
import com.infotel.formation.Mapper.EditorMapper;
import com.infotel.formation.entity.Editor;
import com.infotel.formation.exception.ServiceException;
import com.infotel.formation.interfaces.EditorService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;

@RestController
public class EditorController {

	@Autowired
	EditorService editorService;

	@Autowired
	EditorMapper mapper;

	@GetMapping(value = "/editor/get")
	public Resultat getBooks() {
		Resultat res = new Resultat();
		try {
			List<EditorDTO> viewEditor = new ArrayList<EditorDTO>();

			List<Editor> editors = editorService.getEditors();

			for (Editor editor : editors) {

				viewEditor.add(mapper.mapIntoEditorDTO(editor));
			}
			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(viewEditor);
		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PutMapping(value = "/editor/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat addAuthor(@RequestBody EditorDTO editorDTO) {
		Resultat res = new Resultat();
		try {
			editorService.insertEditor(mapper.mapIntoEditor(editorDTO));
			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(editorDTO);
		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PostMapping(value = "/editor/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat updateAuthor(@RequestBody EditorDTO editorDTO) {
		Resultat res = new Resultat();
		try {
			editorService.updateEditor(mapper.mapIntoEditor(editorDTO));
			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(editorDTO);
		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@DeleteMapping(value = "/editor/delete", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat deleteAuthor(@RequestBody EditorDTO editorDTO) {
		Resultat res = new Resultat();
		try {
			editorService.deleteEditor(editorService.getEditorById(editorDTO.getEditor_id()));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(editorDTO);
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
