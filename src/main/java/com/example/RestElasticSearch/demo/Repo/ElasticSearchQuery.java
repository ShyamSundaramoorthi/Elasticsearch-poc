package com.example.RestElasticSearch.demo.Repo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RestElasticSearch.demo.model.RestElasticModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ElasticSearchQuery {

	@Autowired
	private ElasticsearchClient elasticsearchClient;

	private final String indexName = "sfdb_mkkl_occupation";

	/*
	 * public RestElasticModel getDocumentById(String makkal_id) throws IOException{
	 * RestElasticModel field = null; GetResponse<RestElasticModel> response =
	 * elasticsearchClient.get(g -> g .index(indexName) .id(makkal_id),
	 * RestElasticModel.class );
	 * 
	 * if (response.found()) { field = response.source();
	 * System.out.println("field name " + field.
	 * getOcp()+" "+field.getMakkal_id()+" "+field.get_id()); } else {
	 * System.out.println ("field not found"); }
	 * 
	 * return field; }
	 * 
	 */
	public List<RestElasticModel> getAllDocument() throws IOException {
		SearchRequest searchRequest = SearchRequest.of(s -> s.index(indexName));
		SearchResponse searchResponse = elasticsearchClient.search(searchRequest, RestElasticModel.class);

		List<Hit> hits = searchResponse.hits().hits();
		List<RestElasticModel> list = new ArrayList<>();
		for (Hit object : hits) {

			System.out.print(((RestElasticModel) object.source()));
			list.add((RestElasticModel) object.source());

		}
		return list;

	}

}