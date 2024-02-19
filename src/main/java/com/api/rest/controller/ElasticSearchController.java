package com.api.rest.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.Article;
//import com.api.rest.repository.ArticleRepository;

//@RestController
//public class ElasticSearchController {
//	@Autowired
//	ArticleRepository articleRepository;
//	@GetMapping("/articles")
//	public Iterable<Article> getAll(){
//		return this.articleRepository.findAll();
//	}
//	@GetMapping("/articles/find/{name}")
//	public Page<Article> find(@PathVariable String name) {
//		return this.articleRepository.findByAuthorsName(name, null);
//	}
//}
