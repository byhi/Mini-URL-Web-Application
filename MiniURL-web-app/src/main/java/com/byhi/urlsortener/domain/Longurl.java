package com.byhi.urlsortener.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Longurl {

	@GeneratedValue
	@Id
    private long id;
    private String originalurl;
    @OneToMany(mappedBy = "longUrl")
	private List<SortUrl> sortUrlList;
    
    public Longurl() {
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
    public List<SortUrl> getSortUrlList() {
		return sortUrlList;
	}

	public void setSortUrlList(ArrayList<SortUrl> sortUrlList) {
		this.sortUrlList = sortUrlList;
	}

}