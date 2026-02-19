package com.reqres.qa.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.reqres.qa.payloads.User;

public class PostWithPojo {
	
	@Test
	void testUser() {
		
		User user = new User("Vijay", "SDET Lead");
		given()
			.baseUri("https://reqres.in/api")
			.header("x-api-key", "reqres_d125d7a54ea14747a6bf5476483f49a9")
			.header("Content-Type", "application/json")
			.body(user)
			
		.when()
			.post("/users")
		.then()
			.assertThat()
			.statusCode(201)
			.log().all()
			.body("name", equalTo("Vijay"));
	}

}
