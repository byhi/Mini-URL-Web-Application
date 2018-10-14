package com.byhi.urlsortener.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "longurl")
public class Longurl {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "originalurl")
	private String originalurl;

	@OneToMany(mappedBy = "longUrl")
	private List<ShortUrl> sortUrlList;

	public Longurl() {
	}

	public Longurl(String originalurl) {
		this.originalurl = originalurl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOriginalurl() {
		return originalurl;
	}

	public void setOriginalurl(String originalurl) {
		this.originalurl = originalurl;
	}

	public List<ShortUrl> getSortUrlList() {
		return sortUrlList;
	}

	public void setSortUrlList(ArrayList<ShortUrl> sortUrlList) {
		this.sortUrlList = sortUrlList;
	}

}