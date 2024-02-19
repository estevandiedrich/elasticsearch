package com.api.rest.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.Author;
@Repository
public interface AuthorRepository extends ElasticsearchRepository<Author, String> {

}
