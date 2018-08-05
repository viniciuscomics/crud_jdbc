package br.com.system_rh.dao;

import java.util.List;

public interface RepositoryEntity<T> {
	
	List<T>findAll();
	T findToId(Integer id);
	void update(T entity);
	void create(T entity);
	void delete(T entity);	
}
