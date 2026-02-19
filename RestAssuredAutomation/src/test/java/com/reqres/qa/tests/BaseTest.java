package com.reqres.qa.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	
	public static RequestSpecification requestSpec;
	
	static {
	requestSpec = new RequestSpecBuilder()
			.setBaseUri("https://reqres.in/api")
			.addHeader("x-api-key", "reqres_d125d7a54ea14747a6bf5476483f49a9")
			.addHeader("Content-Type", "application/json")
			.build();
	}
}
