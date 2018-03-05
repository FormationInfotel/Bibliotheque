package com.infotel.formation.interfaces;

import java.util.List;

public interface _GenericDAO<T> {
	
	
	void insert(T t);
	
	void update(T t);
	
	void delete(Object id);
		
	List<T> getList(T t);

}
