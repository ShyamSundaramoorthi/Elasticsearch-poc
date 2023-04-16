package com.example.RestElasticSearch.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.RestElasticSearch.demo.Repo.ElasticSearchQuery;
import com.example.RestElasticSearch.demo.model.RestElasticModel;

import java.io.IOException;
import java.util.List;

@RestController
public class RestElasticController {

	@Autowired
	private ElasticSearchQuery elasticSearchQuery;

	@GetMapping("/_search")
	public ResponseEntity<Object> getAllDocument() throws IOException {
		List<RestElasticModel> list = elasticSearchQuery.getAllDocument();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	/**
	 * @GetMapping("/_search") public ResponseEntity<Object>
	 * getDocumentById(@RequestParam String makkal_id) throws IOException {
	 * RestElasticModel field = elasticSearchQuery.getDocumentById(makkal_id);
	 * return new ResponseEntity<>(field, HttpStatus.OK); }
	 * 
	 */
}
