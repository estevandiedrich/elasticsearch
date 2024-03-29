package com.api.rest;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.HttpHeaders;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.rest.api.repository")
@ComponentScan(basePackages = { "com.rest.api.service" })
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {
	@Override
	@Bean
	public RestHighLevelClient elasticsearchClient() {
		HttpHeaders compatibilityHeaders = new HttpHeaders();
        compatibilityHeaders.add("Accept", "application/vnd.elasticsearch+json;compatible-with=7");
        compatibilityHeaders.add("Content-Type", "application/vnd.elasticsearch+json;"
                + "compatible-with=7");

        final ClientConfiguration clientConfiguration =
                ClientConfiguration
                        .builder()
                        .connectedTo("172.19.0.2:9200")
                        .usingSsl()
                        .withBasicAuth("elastic", "4BCpzhBlff0KMQajdsxG")
                        .withDefaultHeaders(compatibilityHeaders)    // this variant for imperative code
                        .build();

        RestHighLevelClient client = RestClients.create(clientConfiguration).rest();
        return client;
	}
}
