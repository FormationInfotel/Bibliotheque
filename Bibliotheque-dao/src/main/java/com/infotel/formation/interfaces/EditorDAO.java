package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Editor;

public interface EditorDAO {
	void insertEditor(Editor editor);

	public Editor getEditorById(int editorId);

	Editor getEditor(String editorName);

	List<Editor> getEditors();

	List<Editor> getListEditorByKeyword(String editorName);
}
