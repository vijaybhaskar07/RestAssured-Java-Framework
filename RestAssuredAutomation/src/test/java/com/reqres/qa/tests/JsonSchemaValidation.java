package com.reqres.qa.tests;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//json ---> jsonschema converter
//https://jsonformatter.org/json-to-jsonschema

public class JsonSchemaValidation {
	
	@Test
	void jsonSchemaValidation() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ReqresSchema.json"));
		
		
		
	}

}
