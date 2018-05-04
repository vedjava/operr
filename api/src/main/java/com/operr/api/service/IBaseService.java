package com.operr.api.service;

import java.util.List;
import java.util.Optional;

/**
 * The Interface IService
 * @author Ved
 * @param <T> the generic type
 */
public interface IBaseService<T> {
	
	Optional<T> getById(Long id);
	
	List<T> listAll();
	
	T saveOrUpdate(T entity);
	
	void deleteById(Long id);
	
	public void deleteAll();
	
}