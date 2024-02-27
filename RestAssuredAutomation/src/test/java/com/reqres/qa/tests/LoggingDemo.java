package com.reqres.qa.tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LoggingDemo {

	@Test
	public void testLogs() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		
		.then()
			//.log().body();
			//.log().cookies();
			//.log().headers();
			.log().all();
		
		
	}

}
