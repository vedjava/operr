package com.operr.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.operr.api.entity.BaseEntity;
import com.operr.api.service.IBaseService;

public class BaseRestController<T extends BaseEntity> {

	@Autowired
	private IBaseService<T> service;

	@GetMapping
	public ResponseEntity<List<T>> list() {
		List<T> list = service.listAll();
		if(list.isEmpty()){
			return new ResponseEntity<List<T>>(HttpStatus.NO_CONTENT);
			//may return HttpStatus.NOT_FOUND as well
		}
		return new ResponseEntity<List<T>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<T> get(@PathVariable(value = "id") long id) {
		System.out.println("Fetching with id " + id);
		Optional<T> optional = service.getById(id);
		if (!optional.isPresent()) {
			return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<T>(optional.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<T> create(@RequestBody T entity) {
		T e = service.saveOrUpdate(entity);
		return new ResponseEntity<T>(e, HttpStatus.CREATED);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<T> update(@PathVariable(value = "id") long id, @RequestBody T entity) { 
		T e = service.saveOrUpdate(entity);
		return new ResponseEntity<T>(e, HttpStatus.OK);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<T> delete(@PathVariable(value = "id") long id) { 
		service.deleteById(id); 
		return new ResponseEntity<T>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	public ResponseEntity<T> deleteAll() { 
		service.deleteAll();
		return new ResponseEntity<T>(HttpStatus.NO_CONTENT);
	}
}