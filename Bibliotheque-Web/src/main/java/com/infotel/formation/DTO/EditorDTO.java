package com.infotel.formation.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EditorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long editor_id;
	private String editor_name;
	private String editor_address;

	private List<Long> editor_listeBookId;

	public EditorDTO() {
	}

	public EditorDTO(String editor_name, String editor_address) {
		this.editor_name = editor_name;
		this.
		editor_listeBookId = new ArrayList<Long>();
	}

	public String getEditor_name() {
		return editor_name;
	}

	public void setEditor_name(String editor_name) {
		this.editor_name = editor_name;
	}

	public List<Long> getEditor_listeBookId() {
		return editor_listeBookId;
	}

	public void setEditor_listeBookId(List<Long> editor_listeBookId) {
		this.editor_listeBookId = editor_listeBookId;
	}

	public long getEditor_id() {
		return editor_id;
	}

	public String getEditor_address() {
		return editor_address;
	}

	public void setEditor_address(String editor_address) {
		this.editor_address = editor_address;
	}

}
