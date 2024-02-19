package com.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.Article;
import com.api.rest.repository.ArticleElasticSearchReactiveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/articles2")
public class ArticleElasticSearchController {
	@Autowired
	ArticleElasticSearchReactiveRepository repository;
	
	@PostMapping
	public Mono<Article> add(@RequestBody Article article){
		return this.repository.save(article);
	}
	@GetMapping("/{title}")
	public Flux<Article> findByTitle(@PathVariable("title") String title){
		return this.repository.findByTitle(title);
	}
	@GetMapping
	public Flux<Article> findAll(){
		return this.repository.findAll();
	}
	@GetMapping("/author/{name}")
	public Flux<Article> findByAuthorsName(@PathVariable("name") String name){
		return this.repository.findByAuthorsName(name);
	}
}
