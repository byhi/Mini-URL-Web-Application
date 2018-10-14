package com.byhi.urlsortener.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shorturl")
public class ShortUrl {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "shorturl")
	private String shortUrl;
	@ManyToOne
	private Longurl longUrl;

	public ShortUrl() {
	}

	public ShortUrl(Longurl longUrl, String shortUrl) {
		this.longUrl = longUrl;
		this.shortUrl = shortUrl;
	}

	public ShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public ShortUrl(Longurl longUrl) {
		this.longUrl = longUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public Longurl getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(Longurl longUrl) {
		this.longUrl = longUrl;
	}

}
