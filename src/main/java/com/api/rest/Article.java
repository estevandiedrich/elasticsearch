package com.api.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "blog")
public class Article {
	public Article(String title) {
		this.title = title;
		this.id = UUID.randomUUID().toString();
	}
	@Id
	private String id;
	@Field(type = FieldType.Text, name = "title")
	private String title;
	
	@Field(type = FieldType.Nested, includeInParent = true)
	private List<Author> authors;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
}
