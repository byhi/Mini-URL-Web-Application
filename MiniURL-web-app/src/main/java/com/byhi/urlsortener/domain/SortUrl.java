package com.byhi.urlsortener.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SortUrl {
	@GeneratedValue
	@Id
	private Long id;
	private String sortUrl;
	@ManyToOne
	private Longurl longUrl;
	
	
	public SortUrl() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSortUrl() {
		return sortUrl;
	}

	public void setSortUrl(String sortUrl) {
		this.sortUrl = sortUrl;
	}

	public Longurl getLongUrlEntity() {
		return longUrl;
	}

	public void setLongUrlEntity(Longurl longUrlEntity) {
		this.longUrl = longUrlEntity;
	}
	
}
