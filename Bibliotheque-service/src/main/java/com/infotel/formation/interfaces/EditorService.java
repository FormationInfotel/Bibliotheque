package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Editor;

public interface EditorService {

	public Editor getEditorById(long editorId);

	public void insertEditor(Editor editor) throws Exception;

	public void updateEditor(Editor editor) throws Exception;

	public void deleteEditor(Editor editor) throws Exception;

	public List<Editor> getEditors() throws Exception;
}
