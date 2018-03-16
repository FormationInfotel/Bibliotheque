package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Editor;

public interface EditorService {

	public Editor getEditorById(long editorId);

	public void insertEditor(Editor editor);

	public void updateEditor(Editor editor);

	public void deleteEditor(Editor editor);

	public List<Editor> getEditors();
}
