package com.byhi.urlsortener.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.byhi.urlsortener.domain.Longurl;

public interface LongUrlRepository extends CrudRepository<Longurl, Long> {

	List<Longurl> findAll();

	@Query("SELECT a FROM Longurl a WHERE a.originalurl=:originalurl")
	Longurl findByUrl(@Param("originalurl") String originalurl);
}
