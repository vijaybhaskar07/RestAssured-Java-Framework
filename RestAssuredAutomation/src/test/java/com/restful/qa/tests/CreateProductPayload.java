package com.restful.qa.tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProductPayload {
	
	@Test
	public void testProductAddition() {
		
		File jsonData = new File("./src/test/resources/Objects.json");
		
		given()
			.contentType(ContentType.JSON)
			.body(jsonData)
		.when()
			.post("https://api.restful-api.dev/objects")
		.then()
			.assertThat()
			.statusCode(200)
			.body("name", equalTo("Apple MacBook Pro 17"));
		
	}

}
