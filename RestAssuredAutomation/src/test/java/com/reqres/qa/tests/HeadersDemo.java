package com.reqres.qa.tests;

import static io.restassured.RestAssured.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class HeadersDemo {
	
	//@Test(priority=1)
	public void testHeaders() {
		
         given()
		
		.when()
			.post("https://www.google.com/")
		
		.then()
			.header("Content-Type", "text/html; charset=UTF-8")
            .and()           
            .header("Server", "gws")
			.log().all();
		
		
	}
	
	@Test(priority=2)
	public void getHeaders() {
		
         Response res= given()
		
		.when()
			.post("https://www.google.com/");
         
     //get single header info    
//     String  headerValue = res.getHeader("Content-Type");
//     System.out.println("The value of Content-Type header is:" +headerValue);
     
     //get all headers info
     
   Headers myHeaders = res.getHeaders();
   for(Header hd:myHeaders) {
	   System.out.println(hd.getName()+"  "+hd.getValue());
	   
   }
		
		
		
	}

}
