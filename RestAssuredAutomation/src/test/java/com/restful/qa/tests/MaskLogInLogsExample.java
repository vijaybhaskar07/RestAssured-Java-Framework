package com.restful.qa.tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;

import io.restassured.RestAssured;

public class MaskLogInLogsExample {
	
	@Test
	public void testMaskingHeaderInLogs() {
		
		 given()
         .config(RestAssured.config().logConfig(LogConfig.logConfig().blacklistHeader("Server")))
         .header("Server", "cloudflare") // Header is sent, but masked in logs
         .when()
         .get("https://api.restful-api.dev/objects")
         .then()
         .log().all() // Will log [BLACKLISTED] instead of the token
         .statusCode(200);
	}

}
