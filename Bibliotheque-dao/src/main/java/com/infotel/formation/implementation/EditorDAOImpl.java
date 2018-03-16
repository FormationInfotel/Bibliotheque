package com.infotel.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Editor;
import com.infotel.formation.interfaces.EditorDAO;

@Repository
@Transactional
public class EditorDAOImpl implements EditorDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertEditor(Editor editor) {
		sessionFactory.getCurrentSession().save(editor);
	}

	@Override
	public void updateEditor(Editor editor) {
		sessionFactory.getCurrentSession().update(editor);
	}

	@Override
	public void deleteEditor(Editor editor) {
		sessionFactory.getCurrentSession().delete(editor);
	}

	@Override
	public Editor getEditorById(long editorId) {
		Editor editorById = null;

		for (Editor editor : getEditors()) {
			if (editor != null && editor.getEditor_id() > 0 && editor.getEditor_id() == editorId) {
				editorById = editor;
				break;
			}
		}
		return editorById;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Editor getEditor(String editorName) {
		Query<Editor> query = sessionFactory.getCurrentSession()
				.createQuery("from Editor Where editor_name LIKE :editorName");
		query.setParameter("editorName", "%" + editorName + "%").list();
		return (Editor) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Editor> getListEditorByKeyword(String editorName) {
		Query<Editor> query = sessionFactory.getCurrentSession()
				.createQuery("from Editor Where editor_name LIKE :editorName");
		query.setParameter("editorName", "%" + editorName + "%").list();
		return query.list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Editor> getEditors() {
		List<Editor> result = (List<Editor>) sessionFactory.getCurrentSession().createQuery("from Editor").list();
		return result;
	}


}
