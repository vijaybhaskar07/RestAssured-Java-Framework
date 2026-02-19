package com.reqres.qa.tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestResponseTest extends BaseTest {
	
	@Test
	public void testRes() {
		
	Response res = given()
	
		.contentType(ContentType.JSON)
		.header("x-api-key", "reqres_d125d7a54ea14747a6bf5476483f49a9")
		
	.when()
		.get("https://reqres.in/api/users?page=2");

		JSONObject jo = new JSONObject(res.asString());
		
		boolean status = false;
		for(int i=0; i<jo.getJSONArray("data").length(); i++) {
		String fName = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println(fName);
			if(fName.equals("Tobias")) {
				status = true;
				break;
			}
		Assert.assertEquals(status, true);
			
		}
	}
		
		@Test
		public void testResponse1() {
			
		given()
			.spec(BaseTest.requestSpec)
			
		.when()
			.get("/users")
			
		.then()
			.assertThat()
			.statusCode(200)
			.log().all();
			
			
		
	}

}