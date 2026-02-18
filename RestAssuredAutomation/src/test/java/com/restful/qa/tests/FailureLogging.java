package com.restful.qa.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class FailureLogging {
	
	
	@Test
	public void testApiFailureLogging() {
		
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://api.restful-api.dev");
		req.basePath("/objects");
		
		given()
			.spec(req)
		.when()
			.get("/7")
		.then()
			.assertThat()
			.log().ifValidationFails()
			.statusCode(200)
			.body("name", equalTo("Apple MacBook Pro 16"));
		
	}

}
