package com.assignment.api.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.api.repositories.BaseRepository;

@Transactional
public class BaseServiceImpl<T, P extends Serializable> implements BaseService<T, P> {

	@Autowired
	private BaseRepository<T, P> baseRepository;

	@Override
	public void flush() {
		baseRepository.flush();
	}

	@Override
	public List<T> findAll() {
		return baseRepository.findAll();
	}

	@Override
	public void deleteAll() {
		baseRepository.deleteAll();
	}

	@Override
	public <S extends T> S save(S entity) {
		return baseRepository.save(entity);
	}

	@Override
	public void delete(T entity) {
		baseRepository.delete(entity);
	}

	@Override
	public List<T> findAll(Sort sort) {
		return baseRepository.findAll(sort);
	}

	@Override
	public <S extends T> S saveAndFlush(S entity) {
		return baseRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends T> boolean exists(Example<S> example) {
		return baseRepository.exists(example);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example) {
		return baseRepository.findAll(example);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		return baseRepository.findAll(example, sort);
	}

	@Override
	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
		return baseRepository.findAll(example, pageable);
	}

	@Override
	public Optional<T> findById(P id) {
		return baseRepository.findById(id);
	}

}
