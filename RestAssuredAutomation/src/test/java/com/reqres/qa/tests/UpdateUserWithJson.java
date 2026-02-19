package com.reqres.qa.tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
 
public class UpdateUserWithJson {
	
	@Test
	void testUpdateUser() {
		
	File json = new File("./src/test/resources/UpdateUser.json");
	
	given()
		.baseUri("https://reqres.in/api")
		.header("Content-Type", "application/json")
		.header("x-api-key", "reqres_d125d7a54ea14747a6bf5476483f49a9")
		.body(json)
		
	.when()
		.put("/users/2")
		
	.then()
		.assertThat()
		.statusCode(200)
		.body("job", equalTo("SDET Manager"));
		
	
	}
	

}
