package com.byhi.urlsortener.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.byhi.urlsortener.domain.Longurl;

@Repository
public interface LongUrlRepository extends CrudRepository<Longurl, Long> {
List<Longurl> findAll();

}
