package com.api.rest.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.Article;

import reactor.core.publisher.Flux;
@Repository
public interface ArticleElasticSearchReactiveRepository extends ReactiveCrudRepository<Article, String> {
	Flux<Article> findByTitle(String title);
	Flux<Article> findByAuthorsName(String name);
}
