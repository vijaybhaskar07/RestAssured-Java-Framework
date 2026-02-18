package com.qa.restful.payloads;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	
	private String name;
	private Data data;
	
	// Constructors
	public Product() {} 
		
	public Product(String name, Data data) {
		this.name = name;
		this.data = data;
	}
	
	//Getters and Setters
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public Data getData() {
		return data;
	}
	
	public void setData(Data data) {
		this.data=data;
	}
	
	

}
