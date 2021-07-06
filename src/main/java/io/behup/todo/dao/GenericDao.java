package io.behup.todo.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {

	void saveOrUpdate(T object);

	void delete(T object);
	
	void deleteById(int id);

	T findById(ID id);

	List<T> findAll();

}
