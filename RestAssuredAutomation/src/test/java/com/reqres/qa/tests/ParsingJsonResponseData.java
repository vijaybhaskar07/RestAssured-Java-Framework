package com.reqres.qa.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponseData {

	@Test
	void testJsonResponse() {

		// Approach1
		given()
			.contentType(ContentType.JSON)

		.when()
			.get("https://reqres.in/api/users?page=2")

		.then()
				.statusCode(200)
				.header("Content-Type", "application/json; charset=utf-8")
				.body("data[5].email", equalTo("rachel.howell@reqres.in"));

	}

	@Test
	void testJsonResponse1() {

		Response res = given().contentType(ContentType.JSON)

				.when().get("https://reqres.in/api/users?page=2");

		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		String email = res.jsonPath().get("data[5].email").toString();
		Assert.assertEquals(email, "rachel.howell@reqres.in");
	}

	@Test
	void testJsonResponsebodyData() {

		Response res = given()
				.contentType(ContentType.JSON)

				.when().get("https://reqres.in/api/users?page=2");

		JSONObject jo = new JSONObject(res.asString()); // Converting response to Json object

		for (int i = 0; i < jo.getJSONArray("data").length(); i++) {
			String email = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			System.out.println(email);

		}
	}

	@Test
	void testJsonResponsebodyData1() {

		Response res = given().contentType(ContentType.JSON)

				.when().get("https://reqres.in/api/users?page=2");

		JSONObject jo = new JSONObject(res.asString()); // Converting response to Json object

		boolean status = false;
		for (int i = 0; i < jo.getJSONArray("data").length(); i++) {
			String email = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			if(email.equals("george.edwards@reqres.in")) {
				status = true;
				break;
			}

		}
		Assert.assertEquals(status, true);
	}

}
