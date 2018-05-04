package com.operr.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.operr.api.dao.BaseRepository;

/**
 * The Class BaseService.
 * @param <T> the generic type
 * @author Ved
 */
public abstract class BaseService<T> {

	/** The dao generic. */
	@Autowired
	protected BaseRepository<T, Long> baseRepository;

	/**
	 * Find one.
	 * @param id the id
	 * @return the t
	 */
	public Optional<T> getById(Long id) {
		return baseRepository.findById(id);
	}

	/**
	 * Find all.
	 * @return the list
	 */
	public List<T> listAll() {
		return baseRepository.findAll();
	}

	/**
	 * Save.
	 * @param entity the entity
	 */
	public T saveOrUpdate(T entity) {
		return baseRepository.save(entity);
	}

	/**
	 * Delete by id.
	 * @param id the entity id
	 */
	@Transactional
	public void deleteById(Long id) {
		baseRepository.deleteById(id);
	}
	
	/**
	 * Delete all.
	 */
	@Transactional
	public void deleteAll() {
		baseRepository.deleteAll();
	}
}