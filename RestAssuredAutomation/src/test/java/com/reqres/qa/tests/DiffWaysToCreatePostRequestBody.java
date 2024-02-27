package com.reqres.qa.tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DiffWaysToCreatePostRequestBody {
	
	
	
	
	//Post request using Hash map
	
	@Test(priority=1)
	public void testPostUsingHashMap(){
		
		HashMap data = new HashMap();
		data.put("name", "sachin");
		data.put("job", "cricketer");
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
			
						
		
		.then()
			.statusCode(201)
			.body("name", equalTo("sachin"))
			.body("job", equalTo("cricketer"))
			.log().all();
			
		
		
	}
	
	public void testDelete() {
		
		given()
		
		.when()
		
		.then()
			.statusCode(200);
	}
	
	

}
