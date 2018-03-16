package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.EditorDTO;
import com.infotel.formation.Mapper.EditorMapper;
import com.infotel.formation.entity.Editor;
import com.infotel.formation.interfaces.EditorService;

@RestController
public class EditorController {
	@Autowired
	EditorService editorService;

	EditorMapper mapper;

	@GetMapping(value = "/editor/get")
	public List<EditorDTO> getBooks() {
		List<EditorDTO> viewEditor = new ArrayList<EditorDTO>();

		List<Editor> editors = editorService.getEditors();

		for (Editor editor : editors) {

			viewEditor.add(mapper.mapIntoEditorDTO(editor));
		}
		return viewEditor;
	}

	@PostMapping(value = "/editor/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void addAuthor(EditorDTO editorDTO) {
		editorService.insertEditor(mapper.mapIntoEditor(editorDTO));
	}

	@PostMapping(value = "/editor/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void updateAuthor(EditorDTO editorDTO) {
		editorService.insertEditor(mapper.mapIntoEditor(editorDTO));
	}

	@PostMapping(value = "/editor/delete", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void deleteAuthor(EditorDTO editorDTO) {
		editorService.insertEditor(mapper.mapIntoEditor(editorDTO));
	}

}
