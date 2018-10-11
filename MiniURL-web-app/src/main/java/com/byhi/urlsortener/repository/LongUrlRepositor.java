package com.byhi.urlsortener.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.byhi.urlsortener.domain.Longurl;

public interface LongUrlRepositor extends CrudRepository<Longurl, Long> {
List<Longurl> findAll();

}
