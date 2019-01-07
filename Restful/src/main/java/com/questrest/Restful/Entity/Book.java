package com.questrest.Restful.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	
	private long id;
	
	
	
	private String title;
	private String name;
	private String author;
	
	public Book() {
		
	}
	
	public Book( String title, String name, String author) {
		
		this.title = title;
		this.name = name;
		this.author = author;
	}
	
	

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
	

	}
}
