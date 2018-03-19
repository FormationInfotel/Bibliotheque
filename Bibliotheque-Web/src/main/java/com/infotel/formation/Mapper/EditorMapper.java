package com.infotel.formation.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.formation.DTO.EditorDTO;
import com.infotel.formation.entity.Book;
import com.infotel.formation.entity.Editor;
import com.infotel.formation.interfaces.BookService;

@Component
public class EditorMapper {

	@Autowired
	BookService bookService;

	public Editor mapIntoEditor(EditorDTO editorDTO) {
		Editor editor = new Editor(editorDTO.getEditor_name(), editorDTO.getEditor_address());
		editor.setEditor_id(editorDTO.getEditor_id());
		for (Long id : editorDTO.getEditor_listeBookId()) {
			editor.getEditor_listeBook().add(bookService.getBookById(id));
		}

		return (editor);
	}

	public EditorDTO mapIntoEditorDTO(Editor editor) {
		EditorDTO editorDTO = new EditorDTO(editor.getEditor_name(), editor.getEditor_address());
		editorDTO.setEditor_id(editor.getEditor_id());
		for (Book book : editor.getEditor_listeBook()) {
			editorDTO.getEditor_listeBookId().add(book.getISBN());
		}

		return (editorDTO);
	}

}
