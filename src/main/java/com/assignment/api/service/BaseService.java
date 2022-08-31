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

	T getOne(P id);

	<S extends T> S save(S entity);

	int countEntities();

	void delete(T entity);

	void deleteAllInBatch();

	List<T> findAll(Sort sort);

	Optional<T> deleteById(Integer id);

	<S extends T> List<S> save(List<S> entities);

	<S extends T> S saveAndFlush(S entity);

	Page<T> findAll(Pageable pageable);

	<S extends T> boolean exists(Example<S> example);

	<S extends T> List<S> findAll(Example<S> example);

	void deleteInBatch(Iterable<T> entities);

	<S extends T> List<S> findAll(Example<S> example, Sort sort);

	<S extends T> Page<S> findAll(Example<S> example, Pageable pageable);
}
