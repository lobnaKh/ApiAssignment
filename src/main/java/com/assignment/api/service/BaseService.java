package com.assignment.api.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface BaseService<T, P extends Serializable> {
	void flush();

	List<T> findAll();

	void deleteAll();

	Optional<T> findById(P id); 

	<S extends T> S save(S entity);

	void delete(T entity);

	List<T> findAll(Sort sort);


	<S extends T> S saveAndFlush(S entity);


	<S extends T> boolean exists(Example<S> example);

	<S extends T> List<S> findAll(Example<S> example);

	<S extends T> List<S> findAll(Example<S> example, Sort sort);

	<S extends T> Page<S> findAll(Example<S> example, Pageable pageable);
}
