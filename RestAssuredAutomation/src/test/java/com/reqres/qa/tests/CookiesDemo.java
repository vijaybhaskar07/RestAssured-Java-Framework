package com.reqres.qa.tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;


public class CookiesDemo {
	
	//@Test(priority=1)
	public void testCookies() {
		
		given()
		
		.when()
			.post("https://www.google.com/")
		
		.then()
			.cookie("AEC", "Ae3NU9O-06JOruNLhegN9qG_mBCYLkrxWVQfWmV86YV2YWT25du3JPOSGg")
			.log().all();		
		
	}
	
	@Test(priority=2)
	public void getCookiesInfo() {
		
		Response res = given()
		
		.when()
			.post("https://developers.google.com/google-apps/tasks/firstapp");
		
	//Single Cookie info	
//	String Cookie_Value = res.getCookie("NID");
//	System.out.println(Cookie_Value);
	
	//Multiple cookies info
		
	Map<String, String> cookies_Values =	res.getCookies();
	//System.out.println(cookies_Values.keySet());
	for(String k: cookies_Values.keySet()) {
		System.out.println(k+"  "+cookies_Values);
		
	}
	
		
		
	}
	

}
