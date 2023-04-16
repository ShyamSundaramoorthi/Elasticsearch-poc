package com.example.RestElasticSearch.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "sfdb_mkkl_occupation")
public class RestElasticModel {

    @Id
    private String 	makkal_id;
    private Long ocp;    
    private String score;

	public String getMakkal_id() {
		return makkal_id;
	}

	public void setMakkal_id(String makkal_id) {
		this.makkal_id = makkal_id;
	}

	public Long getOcp() {
		return ocp;
	}

	public void setOcp(Long ocp) {
		this.ocp = ocp;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

    
 
    
    
    
}