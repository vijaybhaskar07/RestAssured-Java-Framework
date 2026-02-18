package com.restful.qa.tests;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;



import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonResponse {

	@Test
//	public void validateJsonResponse1() {
//
//		given().contentType(ContentType.JSON).when().get("https://api.restful-api.dev/objects").then().statusCode(200)
//				.body("data[2].color", equalTo("Cloudy White")).log().all();
//
//	}
	
	public void validateJsonResponse2() {
		
		Response res = given()
					.contentType(ContentType.JSON)
				.when()
					.get("https://api.restful-api.dev/objects");
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.header("Server"),"cloudflare");
		String price = res.jsonPath().get("data[3].price").toString();
		Assert.assertEquals(price, "389.99");
		
					
	}
	
	@Test
	public void validateJsonResponse3() {
		
		Response res = given().contentType(ContentType.JSON).when().get("https://api.restful-api.dev/objects");
		
		JSONObject jo = new JSONObject(res.asString());
		for(int i=0; i<jo.getJSONArray("data").length(); i++) {
			String color = jo.getJSONArray("data").getJSONObject(i).get("Price").toString();
			System.out.println(color);
			
		
			
		}
	}
	

}
