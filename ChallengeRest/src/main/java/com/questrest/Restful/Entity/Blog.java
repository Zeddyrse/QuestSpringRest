package com.questrest.Restful.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blog")
public class Blog {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	
	private long id;
	
	
	
	private int year;
	private String title;
	private String content;
	
	public Blog() {
		
	}
	
	public Blog( int year, String title, String content) {
		
		this.year = year;
		this.title = title;
		this.content = content;
	}
	
	

	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setName(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setFilm(String content) {
		this.content = content;
	}
	
	@Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
	

	}
}
