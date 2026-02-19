package com.restful.qa.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.qa.restful.payloads.Data;
import com.qa.restful.payloads.Product;

public class CreateProductWithPayload {

	@Test
	public void testAddProduct() {

		Data data = new Data(2019, 1849.99, "Intel Core i9", "1 TB");
		Product product = new Product("Apple MacBook Pro 21", data);

		given()
			.contentType("application/json")
			.body(product)
		.when()
			.post("https://api.restful-api.dev/objects")
		.then()
			.statusCode(200);
	}
}
