package com.reqres.qa.tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQueryParameters {
	
	@Test
	public void testPathAndQueryParameter() {
		
		given()
			.pathParam("myPath", "users")
			.queryParam("page", 2)
			.queryParam("id", 7)
		
		.when()
			.get("https://reqres.in/api/{myPath}")
		
		.then()
			.statusCode(200)
			.log().all();
		
		
	}
	
	
	

}
