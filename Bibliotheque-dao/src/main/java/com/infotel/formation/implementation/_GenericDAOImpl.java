package com.infotel.formation.implementation;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.interfaces._GenericDAO;


@Repository
@Transactional
public abstract class _GenericDAOImpl<T> implements _GenericDAO<T>, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory s;
	
	private Class<T> type;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public _GenericDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}
	
	@Override
	public void insert(T t) {
		this.s.getCurrentSession().save(t);
	}
	

	@Override
	public void update(T t) {
		this.s.getCurrentSession().merge(t);
	}
	
	@Override
	public void delete(Object id) {
		this.s.getCurrentSession().remove(this.s.getCurrentSession().getReference(type, id));
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList(T t) {
		
		Query<T> query = s.getCurrentSession().createQuery("from :T");
		query.setParameter("T", t);
		return (List<T>) query.list();
		
		
//		List<T> result = (List<T>) s.getCurrentSession().createQuery("from :T").list();
//		return result;
	}
	

}
