package com.infotel.formation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Editor;
import com.infotel.formation.interfaces.EditorDAO;
import com.infotel.formation.interfaces.EditorService;

@Service
@Transactional
public class EditorServiceImpl implements EditorService {

	@Autowired
	EditorDAO editorDAO;

	@Override
	public Editor getEditorById(long editorId) {
		return editorDAO.getEditorById(editorId);
	}

	@Override
	public void insertEditor(Editor editor) {
		editorDAO.insertEditor(editor);
	}

	@Override
	public void updateEditor(Editor editor) {
		editorDAO.updateEditor(editor);
	}

	@Override
	public void deleteEditor(Editor editor) {
		editorDAO.deleteEditor(editor);
	}

	@Override
	public List<Editor> getEditors() {
		return editorDAO.getEditors();
	}
}
